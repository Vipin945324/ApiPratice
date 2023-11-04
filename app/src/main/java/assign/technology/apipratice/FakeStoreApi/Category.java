package assign.technology.apipratice.FakeStoreApi;

public class Category {
  private String category;
  private int Image;

    public Category(String category, int image) {
        this.category = category;
        Image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
