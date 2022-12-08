package application;

import java.util.Date;
import java.util.List;

import dao.DaoFactory;
import dao.SellerDAO;
import entities.Department;
import entities.Seller;

public class Program {

    public static void main(String[] args) {


        System.out.println("Seller by ID==========================================");
        SellerDAO sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("Seller by Departamentd====================================");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("Seller All====================================");
        List<Seller> list2 = sellerDao.findAll();

        for(Seller obj : list2){
            System.out.println(obj);
        }

        // System.out.println("Seller Insert====================================");
        // Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        // sellerDao.insert(newSeller);
        // System.out.println("New Seller id: " + newSeller.getId());

        System.out.println("Seller Update====================================");
        seller = sellerDao.findById(2);
        seller.setName("Marcha Waine");
        sellerDao.update(seller);
        System.out.println("Update Completed");

        System.out.println("Seller Delete====================================");
        sellerDao.deleteById(15);;
        System.out.println("Delete Completed");

    }   
    
}
