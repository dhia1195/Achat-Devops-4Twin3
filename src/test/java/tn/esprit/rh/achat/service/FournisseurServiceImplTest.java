
package tn.esprit.rh.achat.service;

        import lombok.extern.slf4j.Slf4j;
        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.Mockito;
        import org.mockito.junit.jupiter.MockitoExtension;
        import org.springframework.stereotype.Service;
        import tn.esprit.rh.achat.entities.CategorieFournisseur;
        import tn.esprit.rh.achat.entities.DetailFournisseur;
        import tn.esprit.rh.achat.entities.Fournisseur;
        import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
        import tn.esprit.rh.achat.repositories.FournisseurRepository;

        import tn.esprit.rh.achat.services.FournisseurServiceImpl;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Optional;

@Service
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplTest   {

    @InjectMocks
    FournisseurServiceImpl FournisseurService;
    @Mock
    FournisseurRepository fournisseurRepository;
    @Mock
    DetailFournisseurRepository detailFournisseurRepository;


    Fournisseur fournisseur = new Fournisseur("f1", "l1", CategorieFournisseur.ORDINAIRE );
    List<Fournisseur> fournisseurList = new ArrayList<Fournisseur>() {
        {
            add(new Fournisseur("f2", "l2", CategorieFournisseur.ORDINAIRE ));
            add(new Fournisseur("f3", "l3", CategorieFournisseur.CONVENTIONNE));
        }
    };

    @Test
    public void testRetrieveAllFournisseurs() {
        Mockito.when(fournisseurRepository.findAll()).thenReturn(fournisseurList);

        List<Fournisseur> result = FournisseurService.retrieveAllFournisseurs();

        Assertions.assertFalse(result.isEmpty());

        Assertions.assertEquals(fournisseurList.size(), result.size());
    }



    @Test
    public void testAddFournisseur() {
        Mockito.when(fournisseurRepository.save(Mockito.any(Fournisseur.class))).thenReturn(fournisseur);

        Fournisseur result = FournisseurService.addFournisseur(fournisseur);

        Mockito.verify(fournisseurRepository, Mockito.times(1)).save(Mockito.eq(fournisseur));

        Assertions.assertEquals(fournisseur, result);
    }


    @Test
    public void testUpdateFournisseur() {
        Fournisseur fournisseur = new Fournisseur("f1", "l1", CategorieFournisseur.ORDINAIRE);
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        detailFournisseur.setDateDebutCollaboration(new Date());
        fournisseur.setDetailFournisseur(detailFournisseur);

        Mockito.when(detailFournisseurRepository.save(Mockito.any(DetailFournisseur.class))).thenReturn(detailFournisseur);

        Mockito.when(fournisseurRepository.save(Mockito.any(Fournisseur.class))).thenReturn(fournisseur);

        Fournisseur result = FournisseurService.updateFournisseur(fournisseur);

        Mockito.verify(detailFournisseurRepository, Mockito.times(1)).save(Mockito.eq(detailFournisseur));

        Mockito.verify(fournisseurRepository, Mockito.times(1)).save(Mockito.eq(fournisseur));

        Assertions.assertEquals(fournisseur, result);
    }



    @Test
    public void testDeleteFournisseur() {
        Long fournisseurId = 1L;

        FournisseurService.deleteFournisseur(fournisseurId);

        Mockito.verify(fournisseurRepository, Mockito.times(1)).deleteById(Mockito.eq(fournisseurId));
    }



    @Test
    public void testRetrieveFournisseur() {
        Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur))
        ;
        Fournisseur fournisseur1 = FournisseurService.retrieveFournisseur(1L);
        Assertions.assertNotNull(fournisseur1);
    }





}