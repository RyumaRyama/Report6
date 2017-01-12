package jp.ac.uryukyu.ie.e165730;


public class Enemy extends LivingThing{
    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }
    public Enemy() {
        super();
    }

    @Override
    public void wounded(int damage){
        setHitPoint(getHitPoint()-damage);
        /*
        if(getHitPoint() <= 0){
            System.out.printf("%sは怒り狂った\n", getName());
            setName("魔王スライム");
            System.out.printf("%sになった\n", getName());
            setAttack(1000);
            setHitPoint(1000);
            System.out.printf("ATK：%d, HP：%d\n", getAttack(), getHitPoint());
        }*/

        if( getHitPoint() <= 0 ) {
            setDead(true);
            System.out.println("モンスター"+getName()+"は倒れた!");
        }
    }
}