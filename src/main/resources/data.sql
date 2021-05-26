DROP TABLE IF EXISTS Simulation;

CREATE TABLE Simulation
(
    simulation_id   INTEGER PRIMARY KEY,
    name            VARCHAR NOT NULL,
    population      INTEGER NOT NULL,
    infected        INTEGER NOT NULL,
    r               INTEGER NOT NULL,
    mortality       INTEGER NOT NULL,
    recovery_time   INTEGER NOT NULL,
    mortality_time  INTEGER NOT NULL,
    simulation_time INTEGER NOT NULL

);

DROP TABLE IF EXISTS Simulation_day;

CREATE TABLE Simulation_day
(
    day_id            INTEGER PRIMARY KEY,
    simulation_id     INTEGER NOT NULL,
    day_number        INTEGER NOT NULL,
    infected_people   INTEGER NOT NULL,
    vulnerable_people INTEGER NOT NULL,
    dead_people       INTEGER NOT NULL,
    healed_people     INTEGER NOT NULL
);

DROP TABLE IF EXISTS Person;

CREATE TABLE Person
(
    person_id      INTEGER PRIMARY KEY,
    simulation_id  INTEGER NOT NULL,
    recovered      BOOLEAN NOT NULL,
    infected       BOOLEAN NOT NULL,
    infection_days INTEGER NOT NULL
)
