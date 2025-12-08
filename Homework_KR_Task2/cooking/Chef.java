public class Chef extends Worker {

	private String post;

	public Chef() {
		super("Вадик");
        this.post = "повар";
	}

	public Chef(String name, String post) {
		super(name);
		setPost(post);
	}

	public void setPost(String post) {
		if (post == null || post.trim().isEmpty()) {
			System.out.println("Введите должность!");
			return;
		}
		this.post = post;
	}

	public String getPost() {
		return this.post;
	}

	@Override
	public void work() {
		System.out.println(getName() + " готовит... Должность: " + post);
	}

	@Override
	public void takeBreak() {
		System.out.println(this.post + " " + getName() + " на перекуре");
	}

	public void createRecipe() {
		System.out.println(getName() + " придумывает новый рецепт...");
	}
}