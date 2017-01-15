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


    @Override
    public void attack(LivingThing opponent){
        if(!isDead()) {
            int damage = ((int) (Math.random() * getAttack()));
            if(damage > 0){
                if(randAttack(20)) {
                    damage *= 2;
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }
                else{
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            }
            else
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
        }
    }
}