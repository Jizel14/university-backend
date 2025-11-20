package com.example.springtest.repository;



import com.example.springtest.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChambreRepo extends JpaRepository<Chambre,Long> {

    List<Chambre> findByBlocChambre_NomBloc(String nomBloc); //keywords
    // keywords -> biderctionnelles


    @Query  ("SELECT c FROM Chambre c JOIN Bloc blc where  c.bloc =: nomBloc") //jpql
    List<Chambre> findByBlocChambreJPQL(String nomBloc);

    //nativeQuery
    @Query(value = "SELECT c.* FROM Chambre c " +
            "JOIN Bloc b ON c.bloc_chambre_id_bloc = b.id_bloc " +
            "WHERE b.nomBloc = :bloc",
            nativeQuery = true)
    List<Chambre> findByBlocNameChambreNative( String nomBloc);

    Chambre findByNumeroChambre(Long numeroChambre);


}

//keywords  :  List<chambre> findByBlocChambre_NomBloc(String nomBloc); bidrectionnells
//JPQL :
//NativeQuery : manipule les tables & colonnes



//we cana't use keyword when we can't access the other entity so we use instead jpql

