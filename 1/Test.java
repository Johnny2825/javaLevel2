import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random random = new Random();

        Object[] participants = new Object[5];
        Object[] let = new Object[4];

        //заполнение массива участников
        for(int i = 0; i < participants.length; i++){
            int flag = random.nextInt(3);
            switch (flag){
               case(0):
                   participants[i] = new Human("Human's name_" + i, random.nextInt(5), (random.nextInt(5) + 1) * 10);
                   break;
               case(1):
                   participants[i] = new Cat("Cat's name_" + i, random.nextInt(5), (random.nextInt(5) + 1) * 10);
                   break;
               case(2):
                   participants[i] = new Robot("Robot's name_" + i, random.nextInt(5), (random.nextInt(5) + 1) * 10);
                   break;
            }
        }

        //заполнение массива препятствий
        int flag = 0;
        for(int i = 0; i < let.length; i++){
            if (flag == 0){
                let[i] = new Wall(random.nextInt(3) + 1);
                flag = 1;
            } else {
                let[i] = new TreadMill((random.nextInt(5) + 1) * 10);
                flag = 0;
            }
        }

        //вывод массива препятствий
        for(int i = 0; i < let.length; i++){
            if (let[i] instanceof Wall){
                System.out.print("Height =  " + ((Wall)let[i]).getHeight() + " ");
            }

            if (let[i] instanceof  TreadMill) {
                System.out.print("Length = " + ((TreadMill)let[i]).getLength() + " ");
            }
        }

        System.out.println();

        //вывод массива участников
        for(int i = 0; i < participants.length; i++){
            if(participants[i] instanceof Human){
                System.out.println("Участник " + i + " " + ((Human)participants[i]).getName() + " can jump " +
                        ((Human)participants[i]).getCanJump() + " can run " + ((Human)participants[i]).getCanRun() + " ");
            }

            if(participants[i] instanceof Cat){
                System.out.println("Участник " + i + " " + ((Cat)participants[i]).getName() + " can jump " +
                        ((Cat)participants[i]).getCanJump() + " can run " + ((Cat)participants[i]).getCanRun() + " ");
            }

            if(participants[i] instanceof Robot){
                System.out.println("Участник " + i + " " + ((Robot)participants[i]).getName() + " can jump " +
                        ((Robot)participants[i]).getCanJump() + " can run " + ((Robot)participants[i]).getCanRun() + " ");
            }

        }


        for(int i = 0; i < participants.length; i++){
            for(int j = 0; j < let.length; j++){
                if (let[j] instanceof Wall){
                    if(participants[i] instanceof Human){
                        if (((Wall)let[j]).getHeight() < ((Human)participants[i]).getCanJump()) {
                            ((Human)participants[i]).jumping(((Wall) let[j]).getHeight());
                        } else {
                            System.out.println(((Human)participants[i]).getName() + " can't jump above " + ((Wall) let[j]).getHeight());
                            break;
                        }
                    }
                    if(participants[i] instanceof Cat){
                        if (((Wall)let[j]).getHeight() < ((Cat)participants[i]).getCanJump()) {
                            ((Cat)participants[i]).jumping(((Wall) let[j]).getHeight());
                        } else {
                            System.out.println(((Cat)participants[i]).getName() + " can't jump above " + ((Wall) let[j]).getHeight());
                            break;
                        }
                    }
                    if(participants[i] instanceof Robot){
                        if (((Wall)let[j]).getHeight() < ((Robot)participants[i]).getCanJump()) {
                            ((Robot)participants[i]).jumping(((Wall) let[j]).getHeight());
                        } else {
                            System.out.println(((Robot)participants[i]).getName() + " can't jump above " + ((Wall) let[j]).getHeight());
                            break;
                        }
                    }

                }

                if (let[j] instanceof  TreadMill){
                    if(participants[i] instanceof Human){
                        if (((TreadMill)let[j]).getLength() <= ((Human)participants[i]).getCanRun()) {
                            ((Human)participants[i]).running(((TreadMill)let[j]).getLength());
                        } else {
                            System.out.println(((Human)participants[i]).getName() + " can't run more " + ((TreadMill)let[j]).getLength());
                            break;
                        }
                    }
                    if(participants[i] instanceof Cat){
                        if (((TreadMill)let[j]).getLength() <= ((Cat)participants[i]).getCanRun()) {
                            ((Cat)participants[i]).running(((TreadMill) let[j]).getLength());
                        } else {
                            System.out.println(((Cat)participants[i]).getName() + " can't run more " + ((TreadMill)let[j]).getLength());
                            break;
                        }
                    }
                    if(participants[i] instanceof Robot){
                        if (((TreadMill)let[j]).getLength() <= ((Robot)participants[i]).getCanRun()) {
                            ((Robot)participants[i]).running(((TreadMill) let[j]).getLength());
                        } else {
                            System.out.println(((Robot)participants[i]).getName() + " can't run more " + ((TreadMill)let[j]).getLength());
                            break;
                        }
                    }
                }

                if (j == let.length - 1){
                    System.out.println("Участник прошел всю полосу");
                }
            }
        }
    }
}
