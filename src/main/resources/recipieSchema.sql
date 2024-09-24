CREATE TABLE Recipe (
        recipe_id INT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        description TEXT,
        prep_time INT, -- in minutes
        cook_time INT, -- in minutes
        total_time INT, -- in minutes
        main_ingredient VARCHAR(100),
        instructions TEXT
);
ALTER TABLE Recipe ADD COLUMN image LONGBLOB;
