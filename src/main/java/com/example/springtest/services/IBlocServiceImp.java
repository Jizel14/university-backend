package com.example.springtest.services;

import com.example.springtest.entity.Bloc;
import com.example.springtest.entity.Chambre;
import com.example.springtest.repository.BlocRepo;
import com.example.springtest.repository.ChambreRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBlocServiceImp implements IBlocService {

    private final BlocRepo blocRepo;
    public IBlocServiceImp(BlocRepo blocRepo) {
        this.blocRepo = blocRepo;
    }


    @Override
    public Bloc addBloc(Bloc bloc){
        return blocRepo.save(bloc);
    };
    @Override
    public Bloc updateBloc(Bloc bloc){
        return blocRepo.save(bloc);
    };
    @Override
    public void deleteByID(Long id){
        blocRepo.deleteById(id);
    };
    @Override
    public Bloc findByID(Long id){
        return blocRepo.findById(id).get();
    };
    @Override
    public List<Bloc> findAll(){
        return blocRepo.findAll();
    };
}
