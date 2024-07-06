package application;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //TIP Um objeto de uma classe sem hashCode e Equals implamentados, compara pela referência, ou seja, será true se for
        // o mesmo objeto ou 2 ponteiros apontando pro mesmo lugar.
        // Caso tenha implementado o hashCode e Equals, a comparação acontece por valor, independete da instância do objeto.

        Set<Product> set = new TreeSet<>();

        set.add
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}