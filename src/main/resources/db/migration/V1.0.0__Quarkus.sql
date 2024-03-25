CREATE TABLE IF NOT EXISTS NOTE
(
    note_id UUID PRIMARY KEY default gen_random_uuid(),
    title VARCHAR(1000)  NOT NULL,
    description VARCHAR  NOT NULL,
    user_id VARCHAR(1000)  NOT NULL

);

