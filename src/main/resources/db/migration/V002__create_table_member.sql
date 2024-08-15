CREATE TABLE IF NOT EXISTS member (
    id                      UUID NOT NULL,
    name                    VARCHAR(255) NOT NULL,
    position                SMALLINT NOT NULL,

    CONSTRAINT pkey_member PRIMARY KEY (id)
);

CREATE INDEX IF NOT EXISTS idx_member_id        ON member (id);
CREATE INDEX IF NOT EXISTS idx_member_name      ON member (name);