package tn.dari.spring.service;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tn.dari.spring.entity.Annonce;
import tn.dari.spring.entity.Estimation;
import tn.dari.spring.entity.SearchAnnonce;
import tn.dari.spring.entity.favoris;
import tn.dari.spring.repository.AnnonceRepository;



@Service
public class AnnonceServiceImpl implements AnnonceService {
	@Autowired
	AnnonceRepository AnnonceRepository;


	@Override
	public Annonce addAnnonce(Annonce annonce) {
		return AnnonceRepository.save(annonce);
	}

	@Override
	public Annonce  UpdateAnnonce(Annonce annonce) {
		return AnnonceRepository.save(annonce);
		
	}

	@Override
	public List<Annonce> retrieveAllAnnonces() {
		return (List<Annonce>) AnnonceRepository.findAll();
	}

	@Override
	public void deleteAnnonce(Long id) {
		AnnonceRepository.deleteById(id);
		
	}

	@Override
	public Annonce retrievesAnnonce(Long id) {
		Annonce a = AnnonceRepository.findById(id).get();
		return a;
	}

	 @Override	
		public List<Annonce> GetBestReductions(){

	    	int A=(int)AnnonceRepository.GetAVGReduction();
	        System.out.println(A);
	    	int C=A+(A/2);
	    	List<Annonce> L_Best_reduction=AnnonceRepository.GetBestReduction(C);
	        System.out.println(C);
	    	return L_Best_reduction;
	    }
	 
	
	 @Override
	    public List<Annonce> SearchBytitle(String Text){
		  
			return AnnonceRepository.findByTextContainingIgnoreCase(Text);
			
		}
	 @PersistenceContext
		private EntityManager em;
	@Override
	public List<Annonce> findByCriteria(SearchAnnonce r) {
		 CriteriaBuilder builder = em.getCriteriaBuilder();
		 CriteriaQuery<Annonce> criteria = builder.createQuery( Annonce.class );
		 Root<Annonce> AdRoot = criteria.from( Annonce.class );
		 criteria.select( AdRoot );
		 List<Predicate> predicates = new ArrayList<>();
	   // predicates.add(builder.between(AdRoot.get("price"),r.getMinPrice(), r.getMaxPrice()));
		//if(r.getStatus() != null){predicates.add(builder.like(AdRoot.get("TypeProp"),r.getStatus()));}
	   // predicates.add(builder.between(AdRoot.get("Surface"),r.getMinArea(),r.getMaxArea()));
	    if(r.getBedRoom()!=0){predicates.add(builder.equal(AdRoot.get("RoomsNum"), r.getBedRoom()));}
	    if(r.getBathroom()!=0){predicates.add(builder.equal(AdRoot.get("bathNum"),r.getBathroom()));}
	 //  if(r.getPropertyType()!=null){predicates.add(builder.equal(AdRoot.get("etat"),r.getPropertyType()));}
	    if(r.getLocation()!=null){predicates.add(builder.equal(AdRoot.get("Localisation"),r.getLocation()));}
	//  if(r.getPiscine()!=null){predicates.add(builder.equal(AdRoot.get("piscine"),AdC.getPiscine()));}
	  criteria.select(AdRoot).where(predicates.toArray(new Predicate[]{}));
		List<Annonce>Annonces  = em.createQuery( criteria ).getResultList();
      return Annonces;	 
	}
	@Override
	 public float findEstimation(Estimation AdE){
		 CriteriaBuilder builder = em.getCriteriaBuilder();
		 CriteriaQuery<Annonce> criteria = builder.createQuery( Annonce.class );
		 Root<Annonce> AdRoot = criteria.from( Annonce.class );
		 criteria.select( AdRoot );
		 List<Predicate> predicates = new ArrayList<>();
		  if(AdE.getDelegation() != null){predicates.add(builder.like(AdRoot.get("Delegation"),AdE.getDelegation()));}
		  if(AdE.getGovernorate() != null){predicates.add(builder.like(AdRoot.get("Governorate"),AdE.getGovernorate()));}
		 if(AdE.getBedRoom()!=0){predicates.add(builder.equal(AdRoot.get("price"), AdE.getPrice()));}
			//if(AdE.getStatus() != null){predicates.add(builder.like(AdRoot.get("TypeProp"),AdE.getStatus()));}
		 if(AdE.getBedRoom()!=0){predicates.add(builder.equal(AdRoot.get("Surface"), AdE.getSurface()));}
		    if(AdE.getBedRoom()!=0){predicates.add(builder.equal(AdRoot.get("RoomsNum"), AdE.getBedRoom()));}
		    if(AdE.getBathroom()!=0){predicates.add(builder.equal(AdRoot.get("bathNum"),AdE.getBathroom()));}
		 //  if(AdE.getPropertyType()!=null){predicates.add(builder.equal(AdRoot.get("OfferType"),AdE.getPropertyType()));}
		    if(AdE.getLocation()!=null){predicates.add(builder.equal(AdRoot.get("Localisation"),AdE.getLocation()));}
		    criteria.select(AdRoot).where(predicates.toArray(new Predicate[]{}));
			List<Annonce> Ads = em.createQuery( criteria ).getResultList();
			int Nbr=0;
		    float somme=0;
		    for(Annonce Ade : Ads){
		    	Nbr=Nbr+1;
		    	somme=somme+Ade.getPrice();
		    }
		    
		    int finalSomme=(int) (somme/Nbr);
		  return finalSomme;
	 }
	 
	 

	


	

}

