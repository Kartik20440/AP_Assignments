import java.util.*;

interface viewlecfunc {
    public void viewlecmaterial(classmaterial material1);
}

interface viewassessfunc {
    public void viewassessment(Assessment ass);
}

interface commoncommentfunc {
    public void addcommentfunc(Comments com, String abc);

    public void viewcommentfunc(Comments comm);
}

class Comments {
    Scanner nsc = new Scanner(System.in);
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<String> com = new ArrayList<>();
    private ArrayList<String> date = new ArrayList<>();

    public void add_comm(String x) {
        System.out.println("Enter comment:");
        String abc = nsc.nextLine();
        java.util.Date d = new java.util.Date();
        String da = d.toString();
        name.add(x);
        com.add(abc);
        date.add(da);
    }

    public void view_comm() {
        for (int i = 0; i < com.size(); i++) {
            System.out.println(com.get(i) +" - "+ name.get(i));
            System.out.println(date.get(i));
            System.out.println("");
        }
    }
}

class classmaterial {
    Scanner s = new Scanner(System.in);
    private ArrayList<Integer> slideinstname = new ArrayList<>();
    private ArrayList<String> topic = new ArrayList<>();
    private ArrayList<Integer> noofslides = new ArrayList<>();
    private ArrayList<ArrayList<String>> content = new ArrayList<>();
    private ArrayList<String> slidedate = new ArrayList<>();
    private ArrayList<Integer> vidinstname = new ArrayList<>();
    private ArrayList<String> vidtopic = new ArrayList<>();
    private ArrayList<String> vidfilename = new ArrayList<>();
    private ArrayList<String> viddate = new ArrayList<>();

    public void addslidemat(int inst) {
        String useless = "";
        ArrayList<String> contentofslide = new ArrayList<>();
        System.out.println("Enter topic of slides:");
        String sl = s.nextLine();
        System.out.println("Enter number of slides:");
        int nosl = s.nextInt();
        useless = s.nextLine();
        System.out.println("Enter content of slides:");
        for (int i = 1; i <= nosl; i++) {
            System.out.println("Content of slide " + i + ":");
            String sno = s.nextLine();
            contentofslide.add(sno);
        }
        java.util.Date d = new java.util.Date();
        String da = d.toString();
        topic.add(sl);
        noofslides.add(nosl);
        content.add(contentofslide);
        slidedate.add(da);
        slideinstname.add(inst);
    }

    public void addvideomat(int inst) {
        System.out.println("Enter topic of video:");
        String sk = s.nextLine();
        System.out.println("Enter filename of video:");
        String fn = s.nextLine();
        if(fn.length() > 4){
            String acc = fn.substring(fn.length() - 4);
            if (acc.equals(".mp4")) {
                java.util.Date d = new java.util.Date();
                String da = d.toString();
                vidinstname.add(inst);
                vidtopic.add(sk);
                vidfilename.add(fn);
                viddate.add(da);
            } 
            else {
                System.out.println("Wrong File Extension!!");
            }
        }
        else {
            System.out.println("Wrong File Extension!!");
        }
    }

    public void viewlmat() {
        System.out.println("");
        for (int i = 0; i < slidedate.size(); i++) {
            System.out.println("Title: " + topic.get(i));
            for (int k = 0; k < content.get(i).size(); k++) {
                System.out.println("Slide " + k + " " + content.get(i).get(k));
            }
            System.out.println("Number of slides: " + noofslides.get(i));
            System.out.println("Date of upload: " + slidedate.get(i));
            System.out.println("Uploaded by: " + slideinstname.get(i));
            System.out.println("");
        }
        for (int i = 0; i < viddate.size(); i++) {
            System.out.println("Title of video: " + vidtopic.get(i));
            System.out.println("Video file: " + vidfilename.get(i));
            System.out.println("Date of upload: " + viddate.get(i));
            System.out.println("Uploaded by: " + vidinstname.get(i));
            System.out.println("");
        }
    }

}

class Assessment {
    Scanner sca = new Scanner(System.in);

    private ArrayList<String> probstat0 = new ArrayList<>();
    private ArrayList<Integer> probmaxmarks0 = new ArrayList<>();
    private ArrayList<String> probstatus0 = new ArrayList<>();
    private ArrayList<String> quizstat0 = new ArrayList<>();
    private ArrayList<Integer> quizmaxmarks0 = new ArrayList<>();
    private ArrayList<String> quizstatus0 = new ArrayList<>();
    private ArrayList<String> quizsubmission = new ArrayList<>();
    private ArrayList<String> probsubmission = new ArrayList<>();
    private ArrayList<String> quizsubmissionstatus = new ArrayList<>();
    private ArrayList<String> probsubmissionstatus = new ArrayList<>();
    
    //Getters
    public ArrayList<String> probstat() {
        return probstat0;
    }
    public ArrayList<Integer> probmaxmarks() {
        return probmaxmarks0;
    }
    public ArrayList<String> probstatus() {
        return probstatus0;
    }
    public ArrayList<String> quizstat() {
        return quizstat0;
    }
    public ArrayList<Integer> quizmaxmarks() {
        return quizmaxmarks0;
    }
    public ArrayList<String> quizstatus() {
        return quizstatus0;
    }

    public void addassign(Student sa, Student sb, Student sc) {
        sca.nextLine();
        System.out.print("Enter problem statement: ");
        String ques = sca.nextLine();
        System.out.print("Enter max marks: ");
        int marks = sca.nextInt();
        probstat().add(ques);
        probmaxmarks().add(marks);
        probstatus().add("Open");
        probsubmission.add("");
        probsubmissionstatus.add("Pending");
        sa.pstat().add(ques);
        sa.pmaxmarks().add(marks);
        sa.psubmission().add("");
        sa.pmarks().add(0);
        sa.psubmissionstatus().add("Pending");
        sa.pgradedby().add("");
        sb.pstat().add(ques);
        sb.pmaxmarks().add(marks);
        sb.psubmission().add("");
        sa.pmarks().add(0);
        sb.psubmissionstatus().add("Pending");
        sb.pgradedby().add("");
        sc.pstat().add(ques);
        sc.pmaxmarks().add(marks);
        sc.psubmission().add("");
        sa.pmarks().add(0);
        sc.psubmissionstatus().add("Pending");
        sb.pgradedby().add("");
    }

    public void addquz(Student sa, Student sb, Student sc) {
        sca.nextLine();
        System.out.print("Enter quiz question: ");
        String q = sca.nextLine();
        quizstat().add(q);
        quizmaxmarks().add(1);
        quizstatus().add("Open");
        quizsubmission.add("");
        quizsubmissionstatus.add("Pending");
        sa.qstat().add(q);
        sa.qsubmission().add("");
        sa.qmarks().add(0);
        sa.qsubmissionstatus().add("Pending");
        sa.qgradedby().add("");
        sb.qstat().add(q);
        sb.qsubmission().add("");
        sa.qmarks().add(0);
        sb.qsubmissionstatus().add("Pending");
        sb.qgradedby().add("");
        sc.qstat().add(q);
        sc.qmarks().add(0);
        sa.qsubmission().add("");
        sc.qsubmissionstatus().add("Pending");
        sc.qgradedby().add("");
    }

    public void view_assessment() {
        int temp = 0;
        for (int i = 0; i < probstat().size(); i++) {
            System.out
                    .println("ID: " + temp + " Assignment: " + probstat().get(i) + " Max Marks: " + probmaxmarks().get(i));
            System.out.println("--------------");
            temp++;
        }
        if (quizstat().size() >= 1) {
            for (int j = 0; j < quizstat().size(); j++) {
                System.out.println("ID: " + temp + " Question: " + quizstat().get(j));
                System.out.println("--------------");
                temp++;
            }
        }
    }

    public int printopenasses() {
        int temp = 0;
        int size = 0;
        for (int i = 0; i < probstat().size(); i++) {
            if (probstatus().get(i).equals("Open")) {
                System.out.println(
                        "ID: " + temp + " Assignment: " + probstat().get(i) + " Max Marks: " + probmaxmarks().get(i));
                System.out.println("--------------");
                temp++;
                size++;
            } else {
                temp++;
            }
        }
        if (quizstat().size() >= 1) {
            for (int j = 0; j < quizstat().size(); j++) {
                if (quizstatus().get(j).equals("Open")) {
                    System.out.println("ID: " + temp + " Question: " + quizstat().get(j));
                    System.out.println("--------------");
                    temp++;
                    size++;
                } else {
                    temp++;
                }
            }
        }
        System.out.println("");
        return size;
    }

    public void printopenasses_help(Student m) {
        int temp = 0;
        for (int i = 0; i < probstat().size(); i++) {
            if (probstatus().get(i).equals("Open") && m.psubmissionstatus().get(i).equals("Pending")) {
                System.out.println(
                        "ID: " + temp + " Assignment: " + probstat().get(i) + " Max Marks: " + probmaxmarks().get(i));
                temp++;
            } else {
                temp++;
            }
        }
        if (quizstat().size() >= 1) {
            for (int j = 0; j < quizstat().size(); j++) {
                if (quizstatus().get(j).equals("Open") && m.qsubmissionstatus().get(j).equals("Pending")) {
                    System.out.println("ID: " + temp + " Question: " + quizstat().get(j));
                    temp++;
                } else {
                    temp++;
                }
            }
        }
        System.out.println("");
    }

    public int printopenasses_help2(Student m) {
        int size = 0;
        for (int i = 0; i < probstat().size(); i++) {
            if (probstatus().get(i).equals("Open") && m.psubmissionstatus().get(i).equals("Pending")) {
                size++;
            }
        }
        if (quizstat().size() >= 1) {
            for (int j = 0; j < quizstat().size(); j++) {
                if (quizstatus().get(j).equals("Open") && m.qsubmissionstatus().get(j).equals("Pending")) {
                    size++;
                }
            }
        }
        return size;
    }
}

class Instructor implements viewlecfunc, viewassessfunc, commoncommentfunc {

    public void addslidematerial(classmaterial material1, int i) {
        material1.addslidemat(i);
    }

    public void addvideomaterial(classmaterial material1, int i) {
        material1.addvideomat(i);
    }

    public void view_lec_mat(classmaterial material1) {
        material1.viewlmat();
    }

    @Override
    public void viewlecmaterial(classmaterial material1) {
        this.view_lec_mat(material1);
    }

    @Override
    public void viewassessment(Assessment assessment1) {
        assessment1.view_assessment();
    }

    @Override
    public void addcommentfunc(Comments comm, String abc) {
        comm.add_comm(abc);
    }

    @Override
    public void viewcommentfunc(Comments com) {
        com.view_comm();
    }

    public void addassignment(Assessment assessment1, Student sp, Student so, Student si) {
        assessment1.addassign(sp, so, si);
    }

    public void addquiz(Assessment assessment1, Student sp, Student so, Student si) {
        assessment1.addquz(sp, so, si);
    }

    public int print_open_asses(Assessment assessment1) {
        int a = assessment1.printopenasses();
        return a;
    }

    public int close_assessment(Assessment assessment1, int a, int ind) {
        if (a + 1 <= assessment1.probstat().size()) {
            assessment1.probstatus().set(a - ind - 1, "Close");
        } 
        else if (a + 1 <= assessment1.probstat().size() + assessment1.quizstat().size()) {
            assessment1.quizstatus().set(a - assessment1.probstat().size(), "Close");
        }
        return ind;
    }
}

class Student implements viewlecfunc, viewassessfunc, commoncommentfunc {
    Scanner s = new Scanner(System.in);
    private ArrayList<String> qstat = new ArrayList<>();
    private ArrayList<String> pstat = new ArrayList<>();
    private ArrayList<String> qsubmission = new ArrayList<>();
    private ArrayList<String> psubmission = new ArrayList<>();
    private ArrayList<String> qsubmissionstatus = new ArrayList<>();
    private ArrayList<String> psubmissionstatus = new ArrayList<>();
    private ArrayList<Integer> pmarks = new ArrayList<>();
    private ArrayList<Integer> pmaxmarks = new ArrayList<>();
    private ArrayList<Integer> qmarks = new ArrayList<>();
    private ArrayList<String> pgradedby = new ArrayList<>();
    private ArrayList<String> qgradedby = new ArrayList<>();

    //Getter
    public ArrayList<String> qstat(){
        return qstat;
    }
    public ArrayList<String> pstat(){
        return pstat;
    }
    public ArrayList<String> qsubmission(){
        return qsubmission;
    }
    public ArrayList<String> psubmission(){
        return psubmission;
    }
    public ArrayList<String> psubmissionstatus(){
        return psubmissionstatus;
    }
    public ArrayList<String> qsubmissionstatus(){
        return qsubmissionstatus;
    }
    public ArrayList<Integer> pmarks(){
        return pmarks;
    }
    public ArrayList<Integer> qmarks(){
        return qmarks;
    }
    public ArrayList<Integer> pmaxmarks(){
        return pmaxmarks;
    }
    public ArrayList<String> pgradedby(){
        return pgradedby;
    }
    public ArrayList<String> qgradedby(){
        return qgradedby;
    }

    public void view_lec_mat(classmaterial material1) {
        material1.viewlmat();
    }

    @Override
    public void viewlecmaterial(classmaterial material1) {
        this.view_lec_mat(material1);
    }

    @Override
    public void viewassessment(Assessment assessment1) {
        assessment1.view_assessment();
    }

    @Override
    public void addcommentfunc(Comments comm, String abc) {
        comm.add_comm(abc);
    }

    @Override
    public void viewcommentfunc(Comments com) {
        com.view_comm();
    }

    public void printasses(Assessment assessment1, Student su) {

        assessment1.printopenasses_help(su);
    }

    public void submit_ass(Student sin, int asid) {
        if (asid + 1 <= sin.psubmissionstatus.size()) {
            System.out.println("Enter filename of assignment: ");
            s.nextLine();
            String aname = s.nextLine();
            if (aname.substring(aname.length() - 4).equals(".zip")) {
                sin.psubmissionstatus.set(asid, "Submitted");
                sin.psubmission.set(asid, aname);
                // System.out.println(sin.psubmissionstatus);
            } else {
                System.out.println("Incorrect File Extension");
            }
        } else if (asid + 1 <= sin.psubmissionstatus.size() + sin.qsubmissionstatus.size()) {
            System.out.println(sin.qstat.get(asid - sin.psubmissionstatus.size()) + " ");
            System.out.println("Enter Your Answer: ");
            String ans = s.nextLine();
            sin.qsubmissionstatus.set(asid - sin.psubmissionstatus.size(), "Submitted");
            sin.qsubmission.set(asid - sin.psubmissionstatus.size(), ans);
            // System.out.println(sin.qsubmissionstatus);
        } else {
            System.out.println("Wrong Input");
        }
    }

    public void view_grades(Student sis) {
        System.out.println("Graded Submissions:");
        for (int i = 0; i < sis.psubmission.size(); i++) {
            if (!sis.psubmission.get(i).equals("")) {
                if (sis.psubmissionstatus.get(i).equals("Graded")) {
                    System.out.println("Submission: " + sis.psubmission.get(i));
                    System.out.println("Marks scored: " + sis.pmarks.get(i));
                    System.out.println("Graded by: " + sis.pgradedby.get(i));
                }
            }
        }
        for (int i = 0; i < sis.qsubmission.size(); i++) {
            if (!sis.qsubmission.get(i).equals("")) {
                if (sis.qsubmissionstatus.get(i).equals("Graded")) {
                    System.out.println("Submission: " + sis.qsubmission.get(i));
                    System.out.println("Marks scored: " + sis.qmarks.get(i));
                    System.out.println("Graded by: " + sis.qgradedby.get(i));
                }
            }
        }
        System.out.println("------------------------------");
        System.out.println("Ungraded Submissions:");
        for (int i = 0; i < sis.psubmission.size(); i++) {
            if (!sis.psubmission.get(i).equals("")) {
                if (sis.psubmissionstatus.get(i).equals("Submitted")) {
                    System.out.println("Submission: " + sis.psubmission.get(i));
                }
            }
        }
        for (int i = 0; i < sis.qsubmission.size(); i++) {
            if (!sis.qsubmission.get(i).equals("")) {
                if (sis.qsubmissionstatus.get(i).equals("Submitted")) {
                    System.out.println("Submission: " + sis.qsubmission.get(i));
                }
            }
        }
        System.out.println("------------------------------");
    }
}

class Main {
    public static void add_comment_func(commoncommentfunc item, Comments com, String abc) {
        item.addcommentfunc(com, abc);
    }

    public static void view_comment_func(commoncommentfunc item, Comments com) {
        item.viewcommentfunc(com);

    }

    public static void view_lec_func(viewlecfunc item, classmaterial mate) {
        item.viewlecmaterial(mate);
    }

    public static void view_ass_func(viewassessfunc item, Assessment assessment1) {
        item.viewassessment(assessment1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Instructor I0 = new Instructor();
        Instructor I1 = new Instructor();
        Student S0 = new Student();
        Student S1 = new Student();
        Student S2 = new Student();
        classmaterial material0 = new classmaterial();
        Assessment assessment0 = new Assessment();
        Comments comment0 = new Comments();
        int inp1 = 0;
        while (inp1 != 3) {
            System.out.println("Welcome to Backpack\n1. Enter as instructor\n2. Enter as student\n3. Exit");
            inp1 = sc.nextInt();
            int inp2 = -1;
            int inp3 = 0;
            switch (inp1) {
                case 1:
                    System.out.println("Instructors:\n0 - I0\n1 - I1\nChoose id: ");
                    inp2 = sc.nextInt();
                    if (inp2 == 0) {
                        while (inp3 != 9) {
                            System.out.println("Welcome I0");
                            System.out.println(
                                    "INSTRUCTOR MENU\n1. Add class material\n2. Add assessments\n3. View lecture materials\n4. View assessments\n5. Grade assessments\n6. Close assessment\n7. View comments\n8. Add comments\n9. Logout");
                            inp3 = sc.nextInt();
                            switch (inp3) {
                                case 1:
                                    System.out.println("1. Add Lecture Slide\n2. Add Lecture Video\nChoose Option:");
                                    int acm = sc.nextInt();
                                    if (acm == 1) {
                                        I0.addslidematerial(material0, 0);
                                    }
                                    if (acm == 2) {
                                        I0.addvideomaterial(material0, 0);
                                    }
                                    break;
                                case 2:
                                    System.out.println("1. Add Assignment\n2. Add Quiz");
                                    System.out.print("Choose Option: ");
                                    int aas = sc.nextInt();
                                    if (aas == 1) {
                                        I0.addassignment(assessment0, S0, S1, S2);
                                    }
                                    if (aas == 2) {
                                        I0.addquiz(assessment0, S0, S1, S2);
                                    }
                                    break;
                                case 3:
                                    view_lec_func(I0, material0);
                                    break;
                                case 4:
                                    view_ass_func(I0, assessment0);
                                    break;
                                case 5:
                                    ArrayList<Student> list_of_stud = new ArrayList<>();
                                    list_of_stud.add(S0);
                                    list_of_stud.add(S1);
                                    list_of_stud.add(S2);
                                    ArrayList<String> list_of_name = new ArrayList<>();
                                    list_of_name.add("S0");
                                    list_of_name.add("S1");
                                    list_of_name.add("S2");
                                    System.out.println("List of assessments");
                                    view_ass_func(I0, assessment0);
                                    System.out.println("Enter ID of assessment to view submissions:");
                                    int key = sc.nextInt();
                                    int asize = assessment0.probstat().size();
                                    int qsize = assessment0.quizstat().size();
                                    String helper;
                                    int ind = 0;
                                    ArrayList<Student> temp = new ArrayList<>();

                                    if (key + 1 <= asize) {
                                        helper = assessment0.probstat().get(key);
                                        // System.out.println(helper);
                                        System.out.println("Choose ID from these ungraded submissions:");
                                        for (int i = 0; i < list_of_stud.size(); i++) {
                                            if (list_of_stud.get(i).pstat().contains(helper)
                                                    && list_of_stud.get(i).psubmissionstatus()
                                                            .get(list_of_stud.get(i).pstat().indexOf(helper))
                                                            .equals("Submitted")) {
                                                System.out.println(ind + ". " + list_of_name.get(i));
                                                temp.add(list_of_stud.get(i));
                                                ind++;
                                            }
                                        }
                                        int input = sc.nextInt();
                                        System.out.println("Submission:");
                                        System.out.println("Submission: " + temp.get(input).psubmission()
                                                .get(temp.get(input).pstat().indexOf(helper)));
                                        System.out.println("-------------------------------");
                                        System.out.println("Max Marks: "
                                                + temp.get(input).pmaxmarks().get(temp.get(input).pstat().indexOf(helper)));
                                        System.out.print("Marks Scored: ");
                                        int marks_given = sc.nextInt();
                                        temp.get(input).pmarks().set(temp.get(input).pstat().indexOf(helper), marks_given);
                                        temp.get(input).psubmissionstatus().set(temp.get(input).pstat().indexOf(helper),
                                                "Graded");
                                        temp.get(input).pgradedby().set(temp.get(input).pstat().indexOf(helper), "I0");

                                    }

                                    else if (key + 1 <= (asize + qsize)) {
                                        helper = assessment0.quizstat().get(key - asize);
                                        System.out.println("Choose ID from these ungraded submissions");
                                        for (int i = 0; i < list_of_stud.size(); i++) {
                                            if (list_of_stud.get(i).qstat().contains(helper)
                                                    && list_of_stud.get(i).qsubmissionstatus()
                                                            .get(list_of_stud.get(i).qstat().indexOf(helper))
                                                            .equals("Submitted")) {
                                                System.out.println(ind + ". " + list_of_name.get(i));
                                                temp.add(list_of_stud.get(i));
                                                ind++;
                                            }
                                        }
                                        int input = sc.nextInt();
                                        System.out.println("Submission:");
                                        System.out.println("Submission: " + temp.get(input).qsubmission()
                                                .get(temp.get(input).qstat().indexOf(helper)));
                                        System.out.println("-------------------------------");
                                        System.out.println("Max Marks: 1");
                                        System.out.print("Marks Scored: ");
                                        int marks_given = sc.nextInt();
                                        temp.get(input).qmarks().set(temp.get(input).qstat().indexOf(helper), marks_given);
                                        temp.get(input).qsubmissionstatus().set(temp.get(input).qstat().indexOf(helper),
                                                "Graded");
                                        temp.get(input).qgradedby().set(temp.get(input).pstat().indexOf(helper), "I0");
                                    } else {
                                        System.out.println("Wrong input");
                                    }
                                    break;

                                case 6:
                                    System.out.println("List of Open Assignments:");
                                    I0.print_open_asses(assessment0);
                                    System.out.println("Enter id of assignment to close: ");
                                    int abc = sc.nextInt();
                                    I0.close_assessment(assessment0, abc, 0);
                                    break;
                                case 7:
                                    view_comment_func(I0, comment0);
                                    break;
                                case 8:
                                    add_comment_func(I0, comment0, "I0");
                                    break;
                                case 9:
                                    break;

                            }
                        }
                    }
                    if (inp2 == 1) {
                        while (inp3 != 9) {
                            System.out.println("Welcome I1");
                            System.out.println(
                                    "INSTRUCTOR MENU\n1. Add class material\n2. Add assessments\n3. View lecture materials\n4. View assessments\n5. Grade assessments\n6. Close assessment\n7. View comments\n8. Add comments\n9. Logout");
                            inp3 = sc.nextInt();
                            switch (inp3) {
                                case 1:
                                    System.out.println("1. Add Lecture Slide\n2. Add Lecture Video\nChoose Option:");
                                    int acm = sc.nextInt();
                                    if (acm == 1) {
                                        I1.addslidematerial(material0, 0);
                                    }
                                    if (acm == 2) {
                                        I1.addvideomaterial(material0, 0);
                                    }
                                    break;
                                case 2:
                                    System.out.println("1. Add Assignment\n2. Add Quiz");
                                    System.out.print("Choose Option: ");
                                    int aas = sc.nextInt();
                                    if (aas == 1) {
                                        I1.addassignment(assessment0, S0, S1, S2);
                                    }
                                    if (aas == 2) {
                                        I1.addquiz(assessment0, S0, S1, S2);
                                    }
                                    break;
                                case 3:
                                    view_lec_func(I1, material0);
                                    break;
                                case 4:
                                    view_ass_func(I1, assessment0);
                                    break;
                                case 5:
                                    ArrayList<Student> list_of_stud = new ArrayList<>();
                                    list_of_stud.add(S0);
                                    list_of_stud.add(S1);
                                    list_of_stud.add(S2);
                                    ArrayList<String> list_of_name = new ArrayList<>();
                                    list_of_name.add("S0");
                                    list_of_name.add("S1");
                                    list_of_name.add("S2");
                                    System.out.println("List of assessments");
                                    view_ass_func(I0, assessment0);
                                    System.out.println("Enter ID of assessment to view submissions:");
                                    int key = sc.nextInt();
                                    int asize = assessment0.probstat().size();
                                    int qsize = assessment0.quizstat().size();
                                    String helper;
                                    int ind = 0;
                                    ArrayList<Student> temp = new ArrayList<>();

                                    if (key + 1 <= asize) {
                                        helper = assessment0.probstat().get(key);
                                        // System.out.println(helper);
                                        System.out.println("Choose ID from these ungraded submissions:");
                                        for (int i = 0; i < list_of_stud.size(); i++) {
                                            if (list_of_stud.get(i).pstat().contains(helper)
                                                    && list_of_stud.get(i).psubmissionstatus()
                                                            .get(list_of_stud.get(i).pstat().indexOf(helper))
                                                            .equals("Submitted")) {
                                                System.out.println(ind + ". " + list_of_name.get(i));
                                                temp.add(list_of_stud.get(i));
                                                ind++;
                                            }
                                        }
                                        int input = sc.nextInt();
                                        System.out.println("Submission:");
                                        System.out.println("Submission: " + temp.get(input).psubmission()
                                                .get(temp.get(input).pstat().indexOf(helper)));
                                        System.out.println("-------------------------------");
                                        System.out.println("Max Marks: "
                                                + temp.get(input).pmaxmarks().get(temp.get(input).pstat().indexOf(helper)));
                                        System.out.print("Marks Scored: ");
                                        int marks_given = sc.nextInt();
                                        temp.get(input).pmarks().set(temp.get(input).pstat().indexOf(helper), marks_given);
                                        temp.get(input).psubmissionstatus().set(temp.get(input).pstat().indexOf(helper),
                                                "Graded");
                                        temp.get(input).pgradedby().set(temp.get(input).pstat().indexOf(helper), "I1");

                                    }

                                    else if (key + 1 <= (asize + qsize)) {
                                        helper = assessment0.quizstat().get(key - asize);
                                        System.out.println("Choose ID from these ungraded submissions");
                                        for (int i = 0; i < list_of_stud.size(); i++) {
                                            if (list_of_stud.get(i).qstat().contains(helper)
                                                    && list_of_stud.get(i).qsubmissionstatus()
                                                            .get(list_of_stud.get(i).qstat().indexOf(helper))
                                                            .equals("Submitted")) {
                                                System.out.println(ind + ". " + list_of_name.get(i));
                                                temp.add(list_of_stud.get(i));
                                                ind++;
                                            }
                                        }
                                        int input = sc.nextInt();
                                        System.out.println("Submission:");
                                        System.out.println("Submission: " + temp.get(input).qsubmission()
                                                .get(temp.get(input).qstat().indexOf(helper)));
                                        System.out.println("-------------------------------");
                                        System.out.println("Max Marks: 1");
                                        System.out.print("Marks Scored: ");
                                        int marks_given = sc.nextInt();
                                        temp.get(input).qmarks().set(temp.get(input).qstat().indexOf(helper), marks_given);
                                        temp.get(input).qsubmissionstatus().set(temp.get(input).qstat().indexOf(helper),
                                                "Graded");
                                        temp.get(input).qgradedby().set(temp.get(input).pstat().indexOf(helper), "I1");
                                    } else {
                                        System.out.println("Wrong input");
                                    }
                                    break;
                                case 6:
                                    System.out.println("List of Open Assignments:");
                                    I1.print_open_asses(assessment0);
                                    System.out.println("Enter id of assignment to close: ");
                                    int abc = sc.nextInt();
                                    I1.close_assessment(assessment0, abc, 0);
                                    break;
                                case 7:
                                    view_comment_func(I1, comment0);
                                    break;
                                case 8:
                                    add_comment_func(I1, comment0, "I1");
                                    break;
                                case 9:
                                    break;

                            }
                        }
                    }
                    if (inp2 != 0 && inp2 != 1) {
                        System.out.println("Wrong Input!!");
                    }
                    break;

                case 2:
                    System.out.println("Students:\n0 - S0\n1 - S1\n2 - S2\nChoose id: ");
                    inp2 = sc.nextInt();
                    if (inp2 == 0) {
                        while (inp3 != 7) {
                            System.out.println("Welcome S0");
                            System.out.println(
                                    "STUDENT MENU\n1. View lecture materials\n2. View assessments\n3. Submit assessment\n4. View grades\n5. View comments\n6. Add comments\n7. Logout");
                            inp3 = sc.nextInt();
                            switch (inp3) {
                                case 1:
                                    view_lec_func(S0, material0);
                                    break;
                                case 2:
                                    view_ass_func(S0, assessment0);
                                    break;
                                case 3:
                                    if (assessment0.printopenasses_help2(S0) > 0) {
                                        System.out.println("Pending assessments:");
                                        S0.printasses(assessment0, S0);
                                        System.out.println("Enter ID of assessment: ");
                                        int asid = sc.nextInt();
                                        S0.submit_ass(S0, asid);
                                    } else {
                                        System.out.println("No pending assessment");
                                    }
                                    break;
                                case 4:
                                    S0.view_grades(S0);
                                    break;
                                case 5:
                                    view_comment_func(S0, comment0);
                                    break;
                                case 6:
                                    add_comment_func(S0, comment0, "S0");
                                    break;
                                case 7:
                                    break;
                            }

                        }
                    }
                    if (inp2 == 1) {
                        while (inp3 != 7) {
                            System.out.println("Welcome S1");
                            System.out.println(
                                    "STUDENT MENU\n1. View lecture materials\n2. View assessments\n3. Submit assessment\n4. View grades\n5. View comments\n6. Add comments\n7. Logout");
                            inp3 = sc.nextInt();
                            switch (inp3) {
                                case 1:
                                    view_lec_func(S1, material0);
                                    break;
                                case 2:
                                    view_ass_func(S1, assessment0);
                                    break;
                                case 3:
                                    if (assessment0.printopenasses_help2(S1) > 0) {
                                        System.out.println("Pending assessments:");
                                        S1.printasses(assessment0, S1);
                                        System.out.println("Enter ID of assessment: ");
                                        int asid = sc.nextInt();
                                        S1.submit_ass(S1, asid);
                                    } else {
                                        System.out.println("No pending assessment");
                                    }
                                    break;
                                case 4:
                                    S1.view_grades(S1);
                                    break;
                                case 5:
                                    view_comment_func(S1, comment0);
                                    break;
                                case 6:
                                    add_comment_func(S1, comment0, "S1");
                                    break;
                                case 7:
                                    break;

                            }

                        }

                    }
                    if (inp2 == 2) {
                        while (inp3 != 7) {
                            System.out.println("Welcome S2");
                            System.out.println(
                                    "STUDENT MENU\n1. View lecture materials\n2. View assessments\n3. Submit assessment\n4. View grades\n5. View comments\n6. Add comments\n7. Logout");
                            inp3 = sc.nextInt();
                            switch (inp3) {
                                case 1:
                                    view_lec_func(S2, material0);
                                    break;
                                case 2:
                                    view_ass_func(S2, assessment0);
                                    break;
                                case 3:
                                    if (assessment0.printopenasses_help2(S2) > 0) {
                                        System.out.println("Pending assessments:");
                                        S2.printasses(assessment0, S2);
                                        System.out.println("Enter ID of assessment: ");
                                        int asid = sc.nextInt();
                                        S2.submit_ass(S2, asid);
                                    } else {
                                        System.out.println("No pending assessment");
                                    }
                                case 4:
                                    S2.view_grades(S2);
                                    break;
                                case 5:
                                    view_comment_func(S2, comment0);
                                    break;
                                case 6:
                                    add_comment_func(S2, comment0, "S2");
                                    break;
                                case 7:
                                    break;

                            }

                        }
                    }
                    if (inp2 != 0 && inp2 != 1 && inp2 != 2) {
                        System.out.println("Wrong Input!!");
                    }
                    break;
            }
        }
    }
}
