package net.team4.dao;

public interface CreateDBInterface {
    
    public boolean verifyExistenceDB();
    public boolean createDB();
    public boolean createTables(int num);
    
}
