package app;

public class TestApp implements Cloneable {

private int id;
private String name;
private HashMap props;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public HashMap getProps() {
    return props;
}

public void setProps(HashMap props) {
    this.props = props;
}

/*
public CloneTest clone() {
  System.out.println("Вызываем переопределенный метод clone()");
  HashMap hm = new HashMap();
  String key;
  Iterator it = this.props.keySet().iterator();
  // глубокое копирование объекта Java
  while (it.hasNext()) {
      key = it.next();
      hm.put(key, this.props.get(key));
  }
    CloneTest ct = new CloneTest();
    ct.setId(this.id);
    ct.setName(this.name);
    ct.setProps(hm);
  return ct;
}
*/
public static void main(String[] args) throws CloneNotSupportedException {

CloneTest ct1 = new CloneTest();
ct1.setId(1);
ct1.setName("первый");
HashMap hm = new HashMap();
hm.put("1", "first");
hm.put("2", "second");
hm.put("3", "third");
ct1.setProps(hm);
// Используем стандартную реализацию метода clone()
CloneTest ct2 = (CloneTest) ct1.clone();

// Проверяем атрибуты ct1 и ct2 на равенство
System.out.println("ct1 и ct2 HashMap == test: "
+ (ct1.getProps() == ct2.getProps()));
// Смотрим эффект от использования стандартной реализации метода clone()
ct1.getProps().put("4", "fourth");
System.out.println("ct2 props:" + ct2.getProps());
ct1.setName("new");
System.out.println("ct2 name:" + ct2.getName());
}

}
