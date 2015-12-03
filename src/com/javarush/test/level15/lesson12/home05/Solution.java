package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    int variable;
    String name;
    boolean pravda;

    private Solution(int variable, String name, boolean pravda) {
        this.variable = variable;
        this.name = name;
        this.pravda = pravda;
    }

    private Solution(String name, boolean pravda) {
        this(0, name, pravda);
    }

    private Solution(boolean pravda) {
        this(0, "", pravda);
    }

    protected Solution(int variable, String name) {
        this.variable = variable;
        this.name = name;
    }

    protected Solution(int variable, boolean pravda) {
        this(0, pravda ? "true" : "false");
    }

    protected Solution(int variable) {
        this(variable, "");
    }

    Solution(int variable1, int variable2, String name) {
        this.variable = variable1 + variable2;
        this.name = name;
    }

    Solution(String firstName, String lastName) {
        this(0, firstName + " " + lastName);
    }

    Solution(boolean pravda1, boolean pravda2) {
        this(0, "", pravda1 | pravda2);
    }


    public Solution(int variable1, int variable2, String firstName, String lastName) {
        this.variable = variable1 + variable2;
        this.name = firstName + " " + lastName;
    }

    public Solution(String name) {
        this(0, name);
    }

    public Solution() {
        this(0, "");
    }
}

