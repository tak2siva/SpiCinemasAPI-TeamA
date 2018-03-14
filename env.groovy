environments {
    dev {
        db_name = 'spicinemas'
        username = 'spiuser'
        password = 'spiuser'
        db_host = "localhost"
        port = 7654
    }
    ci {
        db_name = 'spicinemas'
        username = 'spiuser'
        password = 'spiuser'
        db_host = "db"
        port = 5432
    }
}