package com.javarush.test.level15.lesson12.home05;

/**
 * Created by vampa on 24.01.15.
 */
public class SubSolution extends Solution {

    private SubSolution(int variable, String name, boolean pravda) {
        this.variable = variable;
        this.name = name;
        this.pravda = pravda;
    }

    private SubSolution(String name, boolean pravda) {
        this(0, name, pravda);
    }

    private SubSolution(boolean pravda) {
        this(0, "", pravda);
    }

    protected SubSolution(int variable, String name) {
        super(variable, name);
    }

    protected SubSolution(int variable, boolean pravda) {
        super(variable, pravda);
    }

    protected SubSolution(int variable) {
        super(variable);
    }

    SubSolution(int variable1, int variable2, String name) {
        super(variable1, variable2, name);
    }

    SubSolution(String firstName, String lastName) {
        super(firstName, lastName);
    }

    SubSolution(boolean pravda1, boolean pravda2) {
        super(pravda1, pravda2);
    }

    public SubSolution(int variable1, int variable2, String firstName, String lastName) {
        super(variable1, variable2, firstName, lastName);
    }

    public SubSolution(String name) {
        super(name);
    }

    public SubSolution() {
    }
}
