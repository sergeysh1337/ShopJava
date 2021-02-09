package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(book);
    }

    private Product book;
    private MyListener myListener;

    public void setData(Product book, MyListener myListener) {
        this.book = book;
        this.myListener = myListener;
        nameLabel.setText(book.getName());
        priceLable.setText(Main.CURRENCY + book.getPrice());
        Image image = new Image(getClass().getResourceAsStream(book.getImgSrc()));
        img.setImage(image);
    }
}
