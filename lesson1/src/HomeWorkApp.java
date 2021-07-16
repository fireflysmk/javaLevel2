public class HomeWorkApp {

    public static void main(String[] args) {
        Object[] participants = new Object[]{
                new Human(),
                new Cat(),
                new Robot()
        };

        Object[] obtacles = new Object[]{
                new Wall(1),
                new Wall(9),
                new RunningTrack(90),
                new RunningTrack(800)
        };

        HomeWorkApp app = new HomeWorkApp();


        for(Object participant : participants) {

            boolean isFinishAll = false;


            for(Object obtacle : obtacles) {

                isFinishAll = app.overcomeObtacles(participant, obtacle);
                if (!isFinishAll) {
                    break;
                }
            }

            if (isFinishAll) {
                System.out.println(participant.getClass().toString() + " WINNER");
            }
        }

    }

    public boolean overcomeObtacles(Object participant, Object obtacle) {
        int participantJumpDistance;
        int participantRunDistance;

        int obtcaleJumpDistance;
        int obtcaleRunDistance;

        if (participant instanceof Human) {
            participantJumpDistance = ((Human)participant).getMaxJumpDistance();
            participantRunDistance = ((Human)participant).getMaxRunDistance();
            if (obtacle instanceof Runnable) {
                obtcaleRunDistance = ((RunningTrack)obtacle).getLength();
                ((Human)participant).run();
                if (obtcaleRunDistance > participantRunDistance) {
                    ((Human)participant).jump();
                    System.out.println("Human failed the track");
                    return false;
                } else {
                    return true;
                }
            } else {
                obtcaleJumpDistance = ((Wall)obtacle).getHeight();
                ((Human)participant).jump();
                if (obtcaleJumpDistance > participantJumpDistance) {
                    System.out.println("Human failed the wall");
                    return false;
                } else {
                    return true;
                }
            }
        } else if (participant instanceof Cat) {
            participantJumpDistance = ((Cat)participant).getMaxJumpDistance();
            participantRunDistance = ((Cat)participant).getMaxRunDistance();
            if (obtacle instanceof Runnable) {
                obtcaleRunDistance = ((RunningTrack)obtacle).getLength();
                ((Cat)participant).run();
                if (obtcaleRunDistance > participantRunDistance) {
                    System.out.println("Cat failed the track");
                    return false;
                } else {
                    return true;
                }
            } else {
                obtcaleJumpDistance = ((Wall)obtacle).getHeight();
                ((Cat)participant).jump();
                if (obtcaleJumpDistance > participantJumpDistance) {
                    System.out.println("Cat failed the wall");
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            participantJumpDistance = ((Robot)participant).getMaxJumpDistance();
            participantRunDistance = ((Robot)participant).getMaxRunDistance();
            if (obtacle instanceof Runnable) {
                ((Robot)participant).run();
                obtcaleRunDistance = ((RunningTrack)obtacle).getLength();
                if (obtcaleRunDistance > participantRunDistance) {
                    System.out.println("Robot failed the track");
                    return false;
                } else {
                    return true;
                }
            } else {
                obtcaleJumpDistance = ((Wall)obtacle).getHeight();
                ((Robot)participant).jump();
                if (obtcaleJumpDistance > participantJumpDistance) {
                    System.out.println("Robot failed the wall");
                    return false;
                } else {
                    return true;
                }
            }
        }
    }
}