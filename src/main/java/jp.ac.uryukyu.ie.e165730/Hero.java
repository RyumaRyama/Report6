package jp.ac.uryukyu.ie.e165730;


public class Hero extends LivingThing{
    public Hero(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    @Override
    public void wounded(int damage){
        setHitPoint(getHitPoint()-damage);
        if( getHitPoint() <= 0 ) {
            setDead(true);
            System.out.println("勇者"+getName()+"は道半ばで倒れてしまった。");
        }
    }

    @Override
    public void attack(LivingThing opponent){
        if(!isDead()) {
            int damage = ((int) (Math.random() * getAttack()));
            if(damage > 0){
                if(randAttack(30)) {
                    damage *= 2;
                    System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
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