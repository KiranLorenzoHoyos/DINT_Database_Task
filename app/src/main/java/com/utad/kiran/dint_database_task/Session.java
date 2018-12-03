package com.utad.kiran.dint_database_task;

class Session {
    User user;
    private static volatile Session ourInstance = new Session();
    private Session() {
        this.user = new User();
    }

    static Session getInstance() {
        if (ourInstance == null){
            synchronized (Session.class){
                if (ourInstance == null) {
                    ourInstance = new Session();
                }
            }
        }
        return ourInstance;
    }
}