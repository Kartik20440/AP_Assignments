import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Scanner;

class Vaccine{
    Vector<String> name = new Vector<>();
    Vector<Integer> no = new Vector<>();
    Vector<Integer> gap = new Vector<>();
    void add_vac(String n, int nu, int g){
        name.add(n);
        no.add(nu);
        gap.add(g);
        System.out.println("Vaccine Name: " +n+ ", Number of Doses: "+nu+", Gap Between Doses: "+g);
    }
}
class Hospital{
    Vector<String> name = new Vector<>();
    Vector<Integer> pincode = new Vector<>();
    Vector<Integer> id = new Vector<>();
    int ran = 100000;
    void reg_hosp(String n, int p){
        name.add(n);
        pincode.add(p);
        ran++;
        id.add(ran);
        System.out.println("Hospital Name: "+ n+ ", PinCode: "+p+", Unique ID: "+ran);
    }
}
class Citizen{
    Vector<String> name = new Vector<>();
    Vector<Integer> age = new Vector<>();
    Vector<Long> id = new Vector<>();
    Vector<String> status = new Vector<>();
    Vector<Long> id_for_vacname = new Vector<>();
    Vector<String> vacname = new Vector<>();
    //HashMap<Long, String> vacname = new HashMap<Long, String>();
    Vector<Integer> noofdoses = new Vector<>();
    Vector<Integer> duedate = new Vector<>();
    void reg_cit(String n, int a, long i){
        if(a>= 18){
            name.add(n);
            age.add(a);
            id.add(i);
            status.add("REGISTERED");
            noofdoses.add(0) ;
            duedate.add(0) ; 
            System.out.println("Citizen Name: " + n + ", Age: " +a +", Unique ID: "+i);
        }
        else{
            System.out.println("Only above 18 are allowed");
        }
    }
    void check_vacstatus(long unqid){
        int cid = 0 ; 
        
        for(int i=0; i<id.size(); i++){
            if(id.get(i)== unqid){
                cid = i ; 
                break ; 
            }
        }
        if(status.get(cid) == "REGISTERED"){
                System.out.println("Citizen REGISTERED");
            }
        for(int i=0; i<id_for_vacname.size(); i++){
            if(id_for_vacname.get(i) == unqid){
                if(status.get(cid) == "PARTIALLY VACCINATED"){
                    System.out.println("PARTIALLY VACCINATED");
                    System.out.println("Vaccine Given: "+ vacname.get(i));
                    System.out.println("Number of Doses given: "+ noofdoses.get(cid));
                    System.out.println("Next Dose due date: "+ duedate.get(cid));
                }
                if(status.get(cid) == "FULLY VACCINATED"){
                    System.out.println("FULLY VACCINATED");
                    System.out.println("Vaccine Given: "+ vacname.get(i));
                    System.out.println("Number of Doses given: "+ noofdoses.get(cid));
                }
                break ; 
            }
        }
    }
}
class Slots{
    Vector<String> name = new Vector<>();
    Vector<Integer> id = new Vector<>();
    Vector<Integer> day = new Vector<>();
    Vector<Integer> qty = new Vector<>();
    Hospital h = new Hospital() ;
    Citizen c = new Citizen() ;
    Vaccine v = new Vaccine() ;
    Scanner nsc = new Scanner(System.in);
    void add_slot(int i, int d, int q, String na){
        id.add(i);
        day.add(d);
        qty.add(q);
        name.add(na);
        System.out.println("Slot added by Hospital "+i+" for Day: "+d+", Available Quantity: "+q+" of Vaccine "+na);
    }
    void check_slot(int x ){
        for (int i = 0; i < id.size(); i++) {
            if(id.get(i) == x){
                System.out.println(i+"->Day: "+day.get(i)+" Vaccine: "+name.get(i)+" Available Qty: "+qty.get(i));
            }
        }
    }
    void check_slot(int x , String vn){
        for (int i = 0; i < id.size(); i++) {
            if(id.get(i) == x && vn.equals(name.get(i)) ){
                System.out.println(i+"->Day: "+day.get(i)+" Vaccine: "+name.get(i)+" Available Qty: "+qty.get(i));
            }
        }
    }
    
    void book_slot_pincode(int pnc ,Citizen all_cit, Vaccine all_vac, Hospital all_hosp, Slots all_slot, long unid){
        h = all_hosp;
        v = all_vac;
        c = all_cit;
        //s = all_slot ; 
        for(int i=0; i<h.pincode.size(); i++){
            if(h.pincode.get(i) == pnc){
                System.out.println(h.id.get(i)+" "+ h.name.get(i));
            }
        }
        System.out.println("Enter hospital id: ");
        int nid = nsc.nextInt();
         String vaccine_used =""; 
                for( int k = 0 ; k<c.id_for_vacname.size() ; k++){
                      if(c.id_for_vacname.get(k)==unid){
                          vaccine_used = c.vacname.get(k) ;
                          break ; 
                      }
                }
        int vaccine_index =0; 
                for( int k = 0; k<v.name.size() ; k++){
                    if(vaccine_used.equals(v.name.get(k))){
                        vaccine_index = k ; 
                    }
                }
        int citizen_id_index = 0 ;
        for(int k=0; k<c.id.size(); k++){
            if(c.id.get(k) == unid){
                citizen_id_index = k ; 
            }
        }
        int hosp_id_index = -1 ;
        for( int k = 0 ; k< all_slot.id.size() ; k++){
            if(all_slot.id.get(k) == nid){
                if(vaccine_used.equals(all_slot.name.get(k))){
                    hosp_id_index = k ;
                    if(all_slot.qty.get(k) == 0){
                         System.out.println("No Slot Available");
                         return ; 
                    }
                }
                else if(vaccine_used.equals("") && all_slot.qty.get(k)!=0){
                    hosp_id_index = 0 ; 
                }
            }
        }
        if(hosp_id_index == -1){
            System.out.println("No Slot Available");
                         return ; 
        }
        
        if(c.status.get(citizen_id_index) == "PARTIALLY VACCINATED" && c.duedate.get(citizen_id_index) > all_slot.day.get(hosp_id_index)){
           System.out.println("No Slot Available");
           return ; 
        }
        
        
        all_slot.check_slot(nid);
        System.out.println("Choose Slot: ");
        int st = nsc.nextInt();
         if(all_slot.qty.get(st)==0){
            System.out.println("No Slot Available");
                         return ; 
        }
        int i_for_all = st ; 
               
            int j = citizen_id_index ;
            if(c.status.get(j) == "REGISTERED"){
                c.duedate.set(j , all_slot.day.get(i_for_all) + v.gap.get(vaccine_index) ) ; 
                c.status.set(j,"PARTIALLY VACCINATED");
                System.out.println(c.name.get(j) +" vaccinated with "+all_slot.name.get(i_for_all));
                c.vacname.add(all_slot.name.get(i_for_all));
                c.id_for_vacname.add(unid);
                all_slot.qty.set(st , all_slot.qty.get(st) -1) ; 
                c.noofdoses.set(j , 1) ; 
                if(c.noofdoses.get(j) == v.no.get(vaccine_index)){
                    c.status.set(j,"FULLY VACCINATED");
                }
            return ; 
            }
              
                
                if(c.status.get(j) == "PARTIALLY VACCINATED" && vaccine_used.equals(all_slot.name.get(i_for_all)) && (c.noofdoses.get(j) + 1) ==v.no.get(vaccine_index)) {
                    c.status.set(j,"FULLY VACCINATED");
                    c.noofdoses.set(j , c.noofdoses.get(j) +1) ;
                    System.out.println(c.name.get(j) +" vaccinated with "+all_slot.name.get(i_for_all));
                    all_slot.qty.set(i_for_all ,  all_slot.qty.get(i_for_all) -1) ; 
                    return ; 
                }
                if (c.status.get(j) == "PARTIALLY VACCINATED" && vaccine_used.equals(all_slot.name.get(i_for_all)) && (c.noofdoses.get(j) + 1) < v.no.get(vaccine_index) ){
                    System.out.println(c.name.get(j) +" vaccinated with "+all_slot.name.get(i_for_all));
                    all_slot.qty.set(st , all_slot.qty.get(st) -1) ; 
                    c.noofdoses.set(j , c.noofdoses.get(j) +1) ; 
                    c.duedate.set(j , c.duedate.get(j) + v.gap.get(vaccine_index) ) ; 
                     if(c.noofdoses.get(j) == v.no.get(vaccine_index)){
                        c.status.set(j,"FULLY VACCINATED");
                    }
                    return ;
                }
                
                 else if(c.status.get(j) == "PARTIALLY VACCINATED" && !(vaccine_used.equals(all_slot.name.get(i_for_all)))){
                    System.out.println("Vaccine mixing is not allowed");
                    return ; 
                }
               
    }
    
    void book_slot_vaccine(String vn ,Citizen all_cit, Vaccine all_vac, Hospital all_hosp, Slots all_slot, long unid){
        h = all_hosp;
        v = all_vac;
        c = all_cit;
         
        for(int i=0; i<all_slot.name.size(); i++){
            if(all_slot.name.get(i).equals(vn)){
                for( int k = 0 ;k < h.name.size() ; k++){ 
                    int x = h.id.get(k);
                    int y = all_slot.id.get(i) ; 
                    if(x == y  ){
                        System.out.println(all_slot.id.get(i)+" "+ h.name.get(k));
                    }
                }
            }
        }
        System.out.println("Enter hospital id: ");
        int nid = nsc.nextInt();
         String vaccine_used =vn; 
        int vaccine_index =0; 
                for( int k = 0; k<v.name.size() ; k++){
                    if(vaccine_used.equals(v.name.get(k))){
                        vaccine_index = k ; 
                    }
                }
        int citizen_id_index = 0 ;
        for(int k=0; k<c.id.size(); k++){
            if(c.id.get(k) == unid){
                citizen_id_index = k ; 
            }
        }
        int hosp_id_index = -1 ;
        for( int k = 0 ; k< all_slot.id.size() ; k++){
           if(all_slot.id.get(k) == nid){
               if(vaccine_used.equals(all_slot.name.get(k) )){
                   hosp_id_index = k ; 
                   if(all_slot.qty.get(hosp_id_index)==0){
                       System.out.println("No Slot Available");
                         return ; 
                   }
               }
           }
        }
        if(hosp_id_index == -1){
            System.out.println("No Slot Available");
            return ; 
        }
        
          if(c.status.get(citizen_id_index) == "PARTIALLY VACCINATED" && c.duedate.get(citizen_id_index) > all_slot.day.get(hosp_id_index)){
                   System.out.println("No Slot Available");
                   return ; 
                }
        
        
        all_slot.check_slot(nid , vn);
        System.out.println("Choose Slot: ");
        int st = nsc.nextInt();
        int i_for_all = st ; 
               
                int j = citizen_id_index ; 
                
                if(c.status.get(j) == "REGISTERED"){
                    c.duedate.set(j , all_slot.day.get(i_for_all) + v.gap.get(vaccine_index) ) ; 
                    c.status.set(j,"PARTIALLY VACCINATED");
                    System.out.println(c.name.get(j) +" vaccinated with "+all_slot.name.get(i_for_all));
                    c.vacname.add(all_slot.name.get(i_for_all));
                    c.id_for_vacname.add(unid);
                    all_slot.qty.set(st , all_slot.qty.get(i_for_all) -1) ; 
                    c.noofdoses.set(j , 1) ; 
                    if(c.noofdoses.get(j) == v.no.get(vaccine_index)){
                        c.status.set(j,"FULLY VACCINATED");
                    }
                return ; 
                }
              
                
                if(c.status.get(j) == "PARTIALLY VACCINATED" && vaccine_used.equals(all_slot.name.get(i_for_all))  && (c.noofdoses.get(j) + 1) ==v.no.get(vaccine_index)) {
                    c.status.set(j,"FULLY VACCINATED");
                    c.noofdoses.set(j , c.noofdoses.get(j) +1) ;
                    System.out.println(c.name.get(j) +" vaccinated with "+all_slot.name.get(i_for_all));
                    all_slot.qty.set(i_for_all ,  all_slot.qty.get(i_for_all) -1) ; 
                    return ; 
                }
                if (c.status.get(j) == "PARTIALLY VACCINATED" && vaccine_used.equals(all_slot.name.get(i_for_all)) && (c.noofdoses.get(j) + 1) < v.no.get(vaccine_index) ){
                    System.out.println(c.name.get(j) +" vaccinated with "+all_slot.name.get(i_for_all));
                    all_slot.qty.set(i_for_all , all_slot.qty.get(i_for_all) -1) ; 
                    c.noofdoses.set(j , c.noofdoses.get(j) +1) ; 
                    c.duedate.set(j , c.duedate.get(j) + v.gap.get(vaccine_index) ) ; 
                     if(c.noofdoses.get(j) == v.no.get(vaccine_index)){
                        c.status.set(j,"FULLY VACCINATED");
                    }
                    return ;
                }
                
                 else if(c.status.get(j) == "PARTIALLY VACCINATED" && !(vaccine_used.equals(all_slot.name.get(i_for_all)))){
                    
                    System.out.println("Vaccine mixing is not allowed");
                    return ; 
                }
    }
}
class Main{
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int opt = 0;
        Vaccine vac = new Vaccine();
        Hospital hos = new Hospital();
        Citizen cit = new Citizen();
        Slots sl1 = new Slots();
        while(opt != 8){
            System.out.println("___________________________");
            System.out.println("Welcome to Covin portal");
            System.out.println("___________________________");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("___________________________\n");
            System.out.println("Enter the number corresponding to the Query: ");
            opt = sc.nextInt();
            switch(opt){
                case 1:
                    System.out.println("Vaccine Name: ");
                    String name1 = sc.next();
                    System.out.println("Number of doses: ");
                    int doses = sc.nextInt();
                    if(doses>1){
                        System.out.println("Gap between doses: ");
                        int gap = sc.nextInt();
                        vac.add_vac(name1, doses, gap);
                    }
                    else{
                        vac.add_vac(name1,doses,0);
                    }
                    break;
                case 2:
                    System.out.println("Hospital Name: ");
                    String name2 = sc.next();
                    System.out.println("Pincode: ");
                    int pin = sc.nextInt();
                    hos.reg_hosp(name2, pin);
                    break;
                case 3:
                    System.out.println("Citizen Name: ");
                    String name3 = sc.next();
                    System.out.println("Age: ");
                    int age = sc.nextInt();
                    System.out.println("12 Digit Unique ID: ");
                    long id = sc.nextLong();
                    cit.reg_cit(name3, age, id);
                    break;
                case 4:
                    System.out.println("Enter Registered Hospital ID: ");
                    int i = sc.nextInt();
                    int x = -1 ; 
                    for(int p=0; p<hos.id.size(); p++){
                        if(hos.id.get(p) == i){
                            x = 0 ; 
                            System.out.println("Enter number of Slots to be added: ");
                        int no_slot = sc.nextInt();
                        while(no_slot>0){
                            System.out.println("Enter Day Number: ");
                            int d = sc.nextInt();
                            System.out.println("Enter Quantity: ");
                            int q = sc.nextInt();
                            System.out.println("Select Vaccine-");
                            for(int j=0; j<vac.name.size();j++){
                                System.out.println(j+ ". "+vac.name.get(j));
                            }
                            int in = sc.nextInt();
                            if(in < vac.name.size()){
                                sl1.add_slot(i, d, q,vac.name.get(in));
                            }
                            else{
                                System.out.println("Wrong Vaccine Name");
                            }
                            no_slot--;
                            }
                        }
                    }
                    if(x==-1){
                        System.out.println("No Hospital with ID "+ i +" is registered");
                    }
                    
                    break;
                    
                case 5:
                    System.out.println("Enter Registered Patient Unique ID: ");
                    long id1 = sc.nextLong();
                    int tvar = -1 ;
                    for(int k=0; k<cit.id.size();k++){
                        if(cit.id.get(k) == id1){
                            tvar = 0;
                            System.out.println("1. Search by area");
                            System.out.println("2. Search by Vaccine");
                            System.out.println("3. Exit");
                            System.out.println("Enter option:");
                            int op = sc.nextInt();
                            if(op == 1){
                                System.out.println("Enter PinCode: ");
                                int pc1 = sc.nextInt();
                                sl1.book_slot_pincode(pc1,cit,vac,hos,sl1,id1);
                            }
                            else if(op == 2){
                                System.out.println("Enter Vaccine name: ");
                                String vn = sc.next();
                                sl1.book_slot_vaccine(vn,cit,vac,hos,sl1,id1);
                            }
                            else{
                                break;
                            }
                        }
                    }
                    if(tvar ==-1){
                        System.out.println("No Patient with ID "+ id1 +" is registered");
                    }
                    break;
                case 6:
                    System.out.println("Enter Hospital Id: ");
                    int inpid = sc.nextInt();
                    sl1.check_slot(inpid);
                    break;
                case 7:
                    System.out.println("Enter Patient ID: ");
                    long uniid = sc.nextLong();
                    cit.check_vacstatus(uniid);
                    break;
	    }
    }
}
}