package com.company.Command;

public class Client {

    Command select;
    Command insert;
    Command update;
    Command delete;

    public Client(
            Command select,
            Command insert,
            Command update,
            Command delete
    ) {
        this.select = select;
        this.insert = insert;
        this.update = update;
        this.delete = delete;
    }

    public void selectFromDB() {
        select.execute();
    }

    public void insertFromDB() {
        insert.execute();
    }

    public void updateFromDB() {
        update.execute();
    }

    public void deleteFromDB() {
        delete.execute();
    }

}
