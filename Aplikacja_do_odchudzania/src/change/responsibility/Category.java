package change.responsibility;

class C {
    public int category = 12;

    public void setCategory(int category) {
        this.category = category;
    }
}

public abstract class Category {
    C c = new C();
    Category next;
    public int myCategory;
    abstract int choose (String sex, String height, String weight );
    double BMI (String height, String weight){
        double h = Integer.parseInt(height) /100;
        double w = Integer.parseInt(weight);
        return w / (h*h);
    }
    public void setNext (Category category){
        this.next = category;
    }
    void SetCategory (int a) {
        this.myCategory = a;

    }

    int ReturnMyCategory(){
        return myCategory;
    }


}

class FirstCategory extends Category {
    @Override
    int choose (String sex, String height, String weight){
        if(sex.equals("kobieta") && BMI(height, weight) < 25 ){

            SetCategory(1);
            myCategory = 1;
            c.category = 1;
            return 1;
        }
        else if (next != null) {
            next.choose(sex, height, weight);
            return next.choose(sex, height, weight);
        }
        else
            return 4;
    }
}

class SecondCategory extends Category {
    @Override
    int choose (String sex, String height, String weight){
        if((sex.equals("kobieta") && BMI(height, weight) > 25) || (sex.equals("mezczyzna")) && BMI(height, weight) <25 ){

            SetCategory(2);
            c.category = 2;
            return 2;
        }
        else if (next != null) {
            next.choose(sex, height, weight);
            return next.choose(sex, height, weight);
        }
        else
            return 4;
    }
}


class ThirdCategory extends Category {
    @Override
    int choose (String sex, String height, String weight){
        if(sex.equals("mezczyzna") && BMI(height, weight) >= 25 ){

            SetCategory(3);
            c.category = 3;
            return 3;
        }
        else  {

            return 4;
        }
    }
}


