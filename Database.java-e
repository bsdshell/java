import java.util.*;
import classfile.*;

public class Database {
  public static class Table {
    private final String name;
    private final String[] columnNames;
    private final List<List<Object>> data;

    public Table(String name, String[] columnNames, List<List<Object>> data) {
      this.name = name;
      this.columnNames = columnNames;
      this.data = data;
    }

    public void insert(Object[] row) {
      data.add(Arrays.asList(row));
    }

    public String getName() {
      return name;
    }

    public String[] getColumnNames() {
      return columnNames;
    }

    public List<List<Object>> getData() {
      return data;
    }

    public Table select(String[] projectedColumnNames) {
      // IMPLEMENT ME
      Aron.printList2d(data);
      for(List<Object> list : data){
        for(String cn : projectedColumnNames){
        }
      }
      return new Table("Select", null, null);
    }

    public Table where(String cName, Object value) {
      // IMPLEMENT ME
      int columnInx= 0;
      for(columnInx=0; columnInx<columnNames.length; columnInx++){
          if(columnNames[columnInx].equals(cName)){
              Print.p("columnInx=" + columnInx);
              break;
          }
      }

     Table tab = null;
     for(List<Object> ll : data){
         if(ll.get(columnInx).equals(value)){
             Print.p("columnInx.intValue()=" + value);

             List<List<Object>> rowList = new ArrayList<List<Object>>();
             rowList.add(ll);

             tab = new Table("dog", columnNames, rowList);
             break;
         }
     }

      // return new Table(getName(), null, null);
      return tab; 
    }

    @Override
    public String toString() {
      StringBuffer sb = new StringBuffer(String.join(", ", columnNames)).append("\n");
      for (List<Object> row : data) {
        if (row.size() != 0) {
          Object value = row.get(0);
          sb.append(value == null ? "" : value.toString());
          for (int i = 1; i < row.size(); i++) {
            value = row.get(i);
            sb.append(", ").append(value == null ? "" : value.toString());
          }
        }
        sb.append("\n");
      }
      return sb.toString();
    }
  }

  private final Map<String, Table> tableMap;

  public Database() {
    this.tableMap = new HashMap<String, Table>();
  }

  public void addTable(Table table) {
    this.tableMap.put(table.getName(), table);
  }

  public Table getTable(String tableName) {
    return tableMap.get(tableName);
  }

  public Table innerJoin(Table leftTable, String leftTableKeyName, Table rightTable, String rightTableKeyName) {
    // IMPLEMENT ME
    return new Table("InnerJoin", null, null);
  }

  public static void main(String[] args) {
    Table departmentTable = new Table("departments", new String[]{"id", "name"}, new ArrayList<List<Object>>());
    departmentTable.insert(new Object[] {0, "engineering"});
    departmentTable.insert(new Object[] {1, "finance"});

    Table userTable = new Table("users", new String[]{"id", "department_id", "name"}, new ArrayList<List<Object>>());
    userTable.insert(new Object[] {0, 0, "Ian"});
    userTable.insert(new Object[] {1, 0, "John"});
    userTable.insert(new Object[] {2, 1, "Eddie"});
    userTable.insert(new Object[] {3, 1, "Mark"});

    Table salaryTable = new Table("salaries", new String[]{"id", "user_id", "amount"}, new ArrayList<List<Object>>());
    salaryTable.insert(new Object[] {0, 0, 100});
    salaryTable.insert(new Object[] {1, 1, 150});
    salaryTable.insert(new Object[] {2, 1, 200});
    salaryTable.insert(new Object[] {3, 3, 200});
    salaryTable.insert(new Object[] {4, 3, 300});
    salaryTable.insert(new Object[] {5, 4, 400});

    Database db = new Database();
    db.addTable(departmentTable);
    db.addTable(userTable);
    db.addTable(salaryTable);

    // should print
    // id, department_id, name
    // 1, 0, John
    //
    // select id, department_id, name from users where id = 1
    //
    //System.out.println(db.getTable("users").where("id", 1).select(new String[] {"id", "department_id", "name"}));
    
    Table table = db.getTable("users");
    Print.p(table.getName());
    Table wtable = table.where("id", 1);
    Print.p(wtable.getName());
    Aron.printArray(wtable.columnNames);
    Aron.printList2d(wtable.data);
    wtable.select(new String[]{"name"});

    // should print
    // users.name, departments.name
    // Ian, engineering
    // John, engineering
//    System.out.println(
//        db.innerJoin(db.getTable("users"), "department_id", db.getTable("departments"), "id")
//            .where("departments.name", "engineering")
//            .select(new String[]{"users.name", "departments.name"}));
  }
}
