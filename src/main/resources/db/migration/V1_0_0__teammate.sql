CREATE TABLE IF NOT EXISTS team_mate (
    -- This is an auto incrementing bigint.
    id BIGSERIAL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR,
    current_santa VARCHAR,
   	one_year_back_santa VARCHAR,
    two_years_back_santa VARCHAR,
    three_years_back_santa VARCHAR
);

ALTER TABLE team_mate
    ADD CONSTRAINT team_mate_unique UNIQUE (name);

ALTER TABLE team_mate
    ADD CONSTRAINT team_mate_current_fk FOREIGN KEY (current_santa) 
        REFERENCES team_mate;

ALTER TABLE team_mate
    ADD CONSTRAINT team_mate_one_fk FOREIGN KEY (one_year_back_santa) 
        REFERENCES team_mate;

ALTER TABLE team_mate
    ADD CONSTRAINT team_mate_two_fk FOREIGN KEY (two_years_back_santa) 
        REFERENCES team_mate;

ALTER TABLE team_mate
    ADD CONSTRAINT team_mate_three_fk FOREIGN KEY (three_years_back_santa) 
        REFERENCES team_mate;
