package _02객체지향_이론;
// 객체를 생성후에는 값 변경을 절대로 못한다.
class Product{
	private String data;
	private String name;
	private int price;

	public Product(String data, String name, int price) {
		this.data = data;
		this.name = name;
		this.price = price;
	}
	public String getData() {
		return data;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price <= 0) {
			System.out.println("0보다 큰 값만 입력해주세요");
			return;
		}
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [data=" + data + ", name=" + name + ", price=" + price + "]";
	}
}

public class _03캡슐화3 {

	public static void main(String[] args) {
		
		Product pr = new Product("20231212","치킨",20000);
		pr.setPrice(pr.getPrice()-1000);
		System.out.println(pr);
		
	}

}
