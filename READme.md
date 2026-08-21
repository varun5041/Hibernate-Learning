# Hibernate Learning

My notes while learning Hibernate.

![Hibernate Architecture](images/hibernate-architecture.png)

## What is Hibernate?

Hibernate is a Java ORM (Object-Relational Mapping) tool. It maps Java classes to database tables so you can save/fetch Java objects without writing raw SQL every time.

## Why use it?

- Less boilerplate than JDBC
- No manual mapping of query results to objects
- Handles transactions and connections for you
- Built-in caching

## How it works (see diagram above)

1. **Configuration** — reads `hibernate.cfg.xml` (mapping + DB details)
2. `configure()` → `buildSessionFactory()` → **SessionFactory**
3. `openSession()` → **Session**
4. `beginTransaction()` → **Transaction**
5. Do the operation (save / update / delete / select)
6. `commit()` (or `rollback()` on error)
7. Close the session

## Basic Code

```java
SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();

Session session = factory.openSession();
Transaction tx = session.beginTransaction();

try {
    Employee emp = new Employee();
    emp.setName("Varun");
    session.save(emp);

    tx.commit();
} catch (Exception e) {
    tx.rollback();
} finally {
    session.close();
}

factory.close();
```

## Key Terms

| Term | Meaning |
|---|---|
| **SessionFactory** | Created once per app, heavyweight, thread-safe |
| **Session** | Created per request, lightweight, not thread-safe |
| **Transaction** | A unit of work — commit or rollback |
| **Transient** | New object, not saved yet |
| **Persistent** | Attached to a session, changes auto-tracked |
| **Detached** | Session closed, no longer tracked |

## Basic Entity Mapping

```java
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "emp_name")
    private String name;
}
```

## Querying

```java
// HQL - uses entity/field names, not table/column names
Query query = session.createQuery("FROM Employee WHERE name = :name");
query.setParameter("name", "Varun");
List<Employee> result = query.list();
```

## Repo Structure

- `FirstHibernateProject/` — first basic Hibernate setup
- `HibernateSelective/` — notes on selective querying

## References

- [Hibernate Docs](https://hibernate.org/orm/documentation/)