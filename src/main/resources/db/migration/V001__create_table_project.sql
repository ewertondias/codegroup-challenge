CREATE TABLE IF NOT EXISTS project (
    id                      UUID NOT NULL,
    name                    VARCHAR(255) NOT NULL,
    manager                 VARCHAR(100) NOT NULL,
    start_date              DATE,
    estimated_end_date      DATE,
    actual_end_date         DATE,
    budget                  NUMERIC(14, 2),
    description             TEXT NOT NULL,
    risk                    SMALLINT NOT NULL,
    status                  SMALLINT NOT NULL,

    CONSTRAINT pkey_project PRIMARY KEY (id)
);

CREATE INDEX IF NOT EXISTS idx_project_id       ON project (id);
CREATE INDEX IF NOT EXISTS idx_project_name     ON project (name);
CREATE INDEX IF NOT EXISTS idx_project_manager  ON project (manager);