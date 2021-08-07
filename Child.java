class Parent {
    protected int parentId;
    protected String parentName;
    public Parent(){
        this.parentId=102;
        this.parentName = "James";
    }
    public void display(){
        System.out.println(this.parentId+" "+this.parentName);
    }
}
public class Child extends Parent{
    private int childID;
    private String childName;
    public Child(int childID,String childName){
        this.childID = childID;
        this.childName = childName;
    }
    public void display(){
        super.display();
        System.out.println(this.childID+" "+this.childName);
    }
    public static void main(String[] args) {
        Child childobj = new Child(101,"MArry");
        childobj.display();
    }

}
