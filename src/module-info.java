module ClubEMovie {
    requires javafx.controls;
    requires javafx.fxml;

    opens Application;
    opens Registration;
    opens AddMovie;
    opens CustomerDashboard;
    opens Genres;
    opens BuyMovie;
}