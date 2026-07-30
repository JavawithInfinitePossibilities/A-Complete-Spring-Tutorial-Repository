package com.tutorials.sid.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/*
* 3. GenerationType.SEQUENCE
* Uses a database sequence object to generate IDs. Most efficient strategy.
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
@SequenceGenerator(name = "car_seq", sequenceName = "car_sequence", allocationSize = 50)
private Integer id;
* allocationSize = 50 means Hibernate fetches 50 IDs at once from the DB → reduces DB round trips → best for bulk inserts
* Supports batch inserts efficiently
* Requires database to support sequences (PostgreSQL, Oracle, H2) — MySQL before v8 does NOT support sequences
* Best for: PostgreSQL, Oracle, H2.
* */

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private Integer age;
}


/*
* 4. GenerationType.UUID
* Generates a UUID (Universally Unique Identifier) as the primary key. Added in JPA 3.1 / Hibernate 6.
@Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id;  // field type must be UUID or String
* ID is generated in Java before the INSERT — no DB round trip needed
* Globally unique — safe for distributed systems, microservices, data migration
* Downside: UUIDs are large (16 bytes vs 4 bytes for int), index performance can be worse, not human-readable
* Best for: Distributed systems, microservices, when you need globally unique IDs.
*
* */

/*
* 5. GenerationType.TABLE
* Uses a dedicated database table to simulate a sequence. Hibernate maintains a row in that table to track the next ID value.
@Id
@GeneratedValue(strategy = GenerationType.TABLE, generator = "car_table_gen")
@TableGenerator(name = "car_table_gen", table = "id_generator", pkColumnName = "gen_name", valueColumnName = "gen_value", allocationSize = 1)
private Integer id;
* Works on any database (most portable)
* Slowest strategy — requires a SELECT + UPDATE on the generator table for every ID,
* causes lock contention under high load
* Rarely used in modern applications
* Best for: Legacy systems or databases that support neither sequences nor auto-increment.
* */