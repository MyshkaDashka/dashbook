package by.bsuir.dashka.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dashka on 26.04.2015.
 */
@Entity
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(nullable = false)
    private Integer idFrom;

    @Column(nullable = false)
    private Integer idTo;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private  String title;

    @Column(nullable = false)
    private Boolean status;


}
