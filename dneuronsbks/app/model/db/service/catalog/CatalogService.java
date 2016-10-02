package model.db.service.catalog;

import java.util.List;

import javax.persistence.Query;

import model.db.bean.products.Skus;
import play.db.ebean.Model;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

public class CatalogService {

	@Transactional
	public Skus getById(String id) {
		return JPA.em().find(Skus.class, id);
	}

	public List<Skus> getActiveProducts() {
		
		List<Skus> products = (List<Skus>) new Model.Finder(String.class, Skus.class).where("lower(status) = :statusValue").setParameter("statusValue", "ACTIVE").findList();
		return products;
	}	
}