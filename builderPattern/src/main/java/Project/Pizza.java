package Project;

public class Pizza
{
    private Pizza(final Builder builder)
    {
        this.sauce = builder.sauce;
        this.topping = builder.topping;
        this.dough = builder.dough;
    }
    public static class Builder
    {
        public Builder(){}
        public Builder setDough(String dough)
        {
            this.dough = dough;
            return this;
        }
        public Builder setSauce(String sauce)
        {
            this.sauce = sauce;
            return this;
        }
        public Builder setTopping(String topping)
        {
            this.topping = topping;
            return this;
        }
        public Pizza Build()
        {
            return new Pizza(this);
        }
        private Pizza pizza;
        private String dough = "";
        private String sauce = "";
        private String topping = "";
    }
    private String getDough()
    {
        return this.dough;
    }
    private String getSauce()
    {
        return this.sauce;
    }
    private String getTopping()
    {
        return topping;
    }
    private void setDough(String dough)
    {
        this.dough = dough;
    }
    private void setSauce(String sauce)
    {
        this.sauce = sauce;
    }
    private void setTopping(String topping)
    {
        this.topping = topping;
    }
    public void show()
    {
        System.out.println("dough="+this.getDough());
        System.out.println("sauce="+this.getSauce());
        System.out.println("topping="+this.getTopping());
    }
    private String dough = "";
    private String sauce = "";
    private String topping = "";
    private Builder builder;
}
