package main;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import models.*;

/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Main {
    public static void main(String args[]) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.YEAR, calendar.MONTH, calendar.DATE, 8, 30);
        Queue<Client> queueClients = Files.queueClients();
        Stack<Transaction> transactions = new Stack();
        int op;
        boolean isExit = false;

        do {
            Display.menuMain();
            op = Input.option(3, "Elija una opción: ");
            switch (op) {
                case 1:
                    boolean finished = false;
                    int request = 0;
                    double amount;
                    do {
                        Client currentClient  = queueClients.dequeue();
                        do {
                            Display.menuTicketOffice(currentClient.getName());
                            op = Input.option(6, "Elija la opcion a realizar: ");
                            switch (op) {
                                case 1:
                                    amount = Input.amount("Ingrese la cantidad a retirar: ");
                                    boolean correct = currentClient.withdrawal(amount);
                                    if (correct) {
                                        Display.waitClient(4);
                                        transactions.push(new Transaction("RETIRO", amount));
                                        calendar.add(calendar.MINUTE, 4);
                                    } else {
                                         Display.error("Fondo insuficiente");
                                    }
                                    break;
                                case 2:
                                    amount = Input.amount("Ingrese la cantidad a depositar: ");
                                    currentClient.Deposit(amount);
                                    Display.waitClient(3);
                                    transactions.push(new Transaction("DEPOSITO", amount));
                                    calendar.add(calendar.MINUTE, 3);
                                    break;
                                case 3:
                                    Display.text("Estamos consultando sus movimientos");
                                    Display.waitClient(1, 5);
                                    transactions.push(new Transaction("CONSULTA DE MOVIMIENTOS"));
                                    calendar.add(calendar.MINUTE, 1);
                                    calendar.add(calendar.SECOND, 30);
                                    break;
                                case 4:
                                    Display.text("Actualizando libretas");
                                    Display.waitClient(5);
                                    transactions.push(new Transaction("ACTUALIZANDO LIBRETAS"));
                                    calendar.add(calendar.MINUTE, 5);
                                    break;
                                case 5:
                                    Display.paymentServices();
                                    op = Input.option(4, "Elija el servicio a pagar: ");
                                    Display.waitClient(2);
                                    transactions.push(new Transaction("PAGO SERVICIOS"));
                                    calendar.add(calendar.MINUTE, 2);
                                    break;
                                case 6:
                                    finished = true;
                                    break;
                                default:
                                    if (op != -1) {
                                        Display.error("La opcion no es valida.");
                                    }
                                }
                            request++;
                        } while ((!finished) && (request != 5));
                    Display.text("Operaciones terminadas");
                    } while ((calendar.HOUR != 1) && (!queueClients.isEmpty()));
                    if (queueClients.isEmpty()) {
                        Display.withoutQueue();
                    }
                    break;
                    case 2:
                        if (queueClients.isEmpty()) {
                            Stack<Transaction> operations = new Stack();
                            while (!transactions.isEmpty()) {
                                operations.push(transactions.pop());
                            }
                            Files.saveOperations(operations);
                        } else {
                            Display.withQueue();
                        }
                        break;
                    case 3: 
                        Display.exitSystem();
                        isExit = true;
                        break;
                    default:
                        if (op != -1) {
                            Display.error("La opcion no es valida.");
                        }
            }
        } while(!isExit);
    }
}