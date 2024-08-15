CREATE TABLE IF NOT EXISTS project_member (
    id                      UUID DEFAULT gen_random_uuid(),
    project_id              UUID NOT NULL,
    member_id               UUID NOT NULL,

    CONSTRAINT pkey_project_member              PRIMARY KEY (id),
    CONSTRAINT fk_project_member_project_id     FOREIGN KEY (project_id)    REFERENCES project(id),
    CONSTRAINT fk_project_member_member_id      FOREIGN KEY (member_id)     REFERENCES member(id)
);

CREATE INDEX IF NOT EXISTS idx_project_member_id            ON project_member (id);
CREATE INDEX IF NOT EXISTS idx_project_member_project_id    ON project_member (project_id);
CREATE INDEX IF NOT EXISTS idx_project_member_member_id     ON project_member (member_id);