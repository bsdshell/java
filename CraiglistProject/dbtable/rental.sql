
drop table item;
CREATE TABLE item(
    item_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    phone VARCHAR(40) NOT NULL,
    email VARCHAR(100) NOT NULL,
    description VARCHAR(400) NOT NULL,
    submission_date DATE,
    PRIMARY KEY (item_id)
);
