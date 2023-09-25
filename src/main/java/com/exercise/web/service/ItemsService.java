package com.exercise.web.service;

import com.exercise.web.model.Items;
import com.exercise.web.model.ItemsDTO;
import com.exercise.web.repository.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ItemsService {
    @Autowired
    private ItemsRepository repository;

    public List<Items> getAllItems(){
        return repository.findAll();
    }

    public void createItem(ItemsDTO item){
        log.info("Executing create item");

        Double PTKP = 54000000d;
        Double kawin = 4500000d;
        Double tanggungan = 4500000d;
        Double nett;

        if (item.getStatusMenikah().equals(false)  && item.getPasangan() == null) {
            log.info("Satu");
            Double total_tanggungan = 0d;

            if ( item.getTanggungan().equals(1)  ){
                total_tanggungan = tanggungan *= 1;
            }else if (item.getTanggungan().equals(2)){
                total_tanggungan = tanggungan *= 2;
            }else if (item.getTanggungan().equals(3)){
                total_tanggungan = tanggungan *= 3;
            }


            Double potongJabatan =  (item.getBruto() * 5) / 100;
            nett = item.getBruto() - potongJabatan;

            PTKP = PTKP + total_tanggungan;

            Double PKP = (nett * 12) - PTKP;

            Double jumlahPPhPertahun = 0d;
            Double jumlahPPhperbulan = 0d;
            if ( PKP < 60000000d){
                jumlahPPhPertahun = (PKP * 5) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 60000000d && PKP < 250000000d ){
                jumlahPPhPertahun = (PKP * 15) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 250000000d && PKP < 500000000d){
                jumlahPPhPertahun = (PKP * 25) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 500000000d && PKP < 5000000000d){
                jumlahPPhPertahun = (PKP * 30) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP > 5000000000d){
                jumlahPPhPertahun = (PKP * 35) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            }


            if (PKP < 0){
                PKP = 0d;
                jumlahPPhperbulan = 0d;
                jumlahPPhPertahun = 0d;
                PTKP = 0d;
            }
            Items itemNew = new Items();
            itemNew.setName(item.getName());
            itemNew.setJenisKelamin(item.getJenisKelamin());
            itemNew.setStatusMenikah(item.getStatusMenikah());
            itemNew.setPasangan(item.getPasangan());
            itemNew.setTanggungan(item.getTanggungan());
            itemNew.setBruto(item.getBruto());
            itemNew.setNett(nett);
            itemNew.setPtkp(PTKP);
            itemNew.setPkp(PKP);
            itemNew.setJumlahPphPerbalun(jumlahPPhperbulan);
            itemNew.setJumlahPphPertahun(jumlahPPhPertahun);

            repository.save(itemNew);

        }

        if ( item.getJenisKelamin().equals("pria") && item.getStatusMenikah().equals(true) &&
                (item.getPasangan().equals("iya") || item.getPasangan().equals("tidak")) ){
            log.info("Dua");
            Double total_tanggungan = 0d;

            if ( item.getTanggungan().equals(1)  ){
                total_tanggungan = tanggungan *= 1;
            }else if (item.getTanggungan().equals(2)){
                total_tanggungan = tanggungan *= 2;
            }else if (item.getTanggungan().equals(3)) {
                total_tanggungan = tanggungan *= 3;

            }
            Double potongJabatan =  (item.getBruto() * 5) / 100;
            nett = item.getBruto() - potongJabatan;

            PTKP = PTKP + kawin + total_tanggungan;

            Double PKP = (nett * 12) - PTKP;

            Double jumlahPPhPertahun = 0d;
            Double jumlahPPhperbulan = 0d;
            if ( PKP < 60000000d){
                jumlahPPhPertahun = (PKP * 5) / 100;

            } else if (PKP >= 60000000d && PKP < 250000000d ){
                jumlahPPhPertahun = (PKP * 15) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 250000000d && PKP < 500000000d){
                jumlahPPhPertahun = (PKP * 25) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 500000000d && PKP < 5000000000d){
                jumlahPPhPertahun = (PKP * 30) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP > 5000000000d){
                jumlahPPhPertahun = (PKP * 35) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            }

            if (PKP < 0){
                PKP = 0d;
                jumlahPPhperbulan = 0d;
                jumlahPPhPertahun = 0d;
                PTKP = 0d;
            }
            Items itemNew = new Items();
            itemNew.setName(item.getName());
            itemNew.setJenisKelamin(item.getJenisKelamin());
            itemNew.setStatusMenikah(item.getStatusMenikah());
            itemNew.setPasangan(item.getPasangan());
            itemNew.setTanggungan(item.getTanggungan());
            itemNew.setBruto(item.getBruto());
            itemNew.setPtkp(PTKP);
            itemNew.setPkp(PKP);
            itemNew.setJumlahPphPerbalun(jumlahPPhperbulan);
            itemNew.setNett(nett);
            itemNew.setJumlahPphPertahun(jumlahPPhPertahun);

            repository.save(itemNew);
        }

        if ( item.getJenisKelamin().equals("wanita") && item.getStatusMenikah().equals(true) && item.getPasangan().equals("iya")) {
            log.info("TIga");
            Double total_tanggungan = 0d;

            if ( item.getTanggungan().equals(1)  ){
                total_tanggungan = tanggungan *= 1;
            }else if (item.getTanggungan().equals(2)){
                total_tanggungan = tanggungan *= 2;
            }else if (item.getTanggungan().equals(3)){
                total_tanggungan = tanggungan *= 3;
            }


            Double potongJabatan =  (item.getBruto() * 5) / 100;
            nett = item.getBruto() - potongJabatan;

            PTKP = PTKP + total_tanggungan;

            Double PKP = (nett * 12) - PTKP;

            Double jumlahPPhPertahun = 0d;
            Double  jumlahPPhperbulan = 0d;
            if ( PKP < 60000000d){
                jumlahPPhPertahun = (PKP * 5) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 60000000d && PKP < 250000000d ){
                jumlahPPhPertahun = (PKP * 15) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 250000000d && PKP < 500000000d){
                jumlahPPhPertahun = (PKP * 25) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 500000000d && PKP < 5000000000d){
                jumlahPPhPertahun = (PKP * 30) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP > 5000000000d){
                jumlahPPhPertahun = (PKP * 35) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            }

            if (PKP < 0){
                PKP = 0d;
                jumlahPPhperbulan = 0d;
                jumlahPPhPertahun = 0d;
                PTKP = 0d;
            }
            Items itemNew = new Items();
            itemNew.setName(item.getName());
            itemNew.setJenisKelamin(item.getJenisKelamin());
            itemNew.setStatusMenikah(item.getStatusMenikah());
            itemNew.setPasangan(item.getPasangan());
            itemNew.setTanggungan(item.getTanggungan());
            itemNew.setBruto(item.getBruto());
            itemNew.setNett(nett);
            itemNew.setPtkp(PTKP);
            itemNew.setPkp(PKP);
            itemNew.setJumlahPphPerbalun(jumlahPPhperbulan);
            itemNew.setJumlahPphPertahun(jumlahPPhPertahun);

            repository.save(itemNew);

        }

        if ( item.getJenisKelamin().equals("wanita") && item.getStatusMenikah().equals(true) &&
                item.getPasangan().equals("tidak") ){
            log.info("Empat");
            Double total_tanggungan = 0d;

            if ( item.getTanggungan().equals(1)  ){
                total_tanggungan = tanggungan *= 1;
            }else if (item.getTanggungan().equals(2)){
                total_tanggungan = tanggungan *= 2;
            }else if (item.getTanggungan().equals(3)){
                total_tanggungan = tanggungan *= 3;
            }

            Double potongJabatan =  (item.getBruto() * 5) / 100;
            nett = item.getBruto() - potongJabatan;

            PTKP = PTKP + kawin + total_tanggungan;
            Double PKP = (nett * 12) - PTKP;

            Double jumlahPPhPertahun = 0d;
            Double jumlahPPhperbulan = 0d;
            if ( PKP < 60000000d){
                jumlahPPhPertahun = (PKP * 5) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 60000000d && PKP < 250000000d ){
                jumlahPPhPertahun = (PKP * 15) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 250000000d && PKP < 500000000d){
                jumlahPPhPertahun = (PKP * 25) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 500000000d && PKP < 5000000000d){
                jumlahPPhPertahun = (PKP * 30) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP > 5000000000d){
                jumlahPPhPertahun = (PKP * 35) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            }

            if (PKP < 0){
                PKP = 0d;
                jumlahPPhperbulan = 0d;
                jumlahPPhPertahun = 0d;
                PTKP = 0d;
            }
            Items itemNew = new Items();
            itemNew.setName(item.getName());
            itemNew.setJenisKelamin(item.getJenisKelamin());
            itemNew.setStatusMenikah(item.getStatusMenikah());
            itemNew.setPasangan(item.getPasangan());
            itemNew.setTanggungan(item.getTanggungan());
            itemNew.setBruto(item.getBruto());
            itemNew.setPtkp(PTKP);
            itemNew.setPkp(PKP);
            itemNew.setJumlahPphPerbalun(jumlahPPhperbulan);
            itemNew.setNett(nett);
            itemNew.setJumlahPphPertahun(jumlahPPhPertahun);

            repository.save(itemNew);
        }


    }

    public Items getItem(Long id){
        log.info("Executing update with {}",id);
        Optional<Items> items = repository.findById(id);
        return  items.get();
    }

    public void update(ItemsDTO itemsDTO){
        Items itemUpdate =  getItem(itemsDTO.getId());
        log.info("Executing create item");

        Double PTKP = 54000000d;
        Double kawin = 4500000d;
        Double tanggungan = 4500000d;
        Double nett;

        if (itemsDTO.getStatusMenikah().equals(false)  && itemsDTO.getPasangan() == null) {
            log.info("Satu");
            Double total_tanggungan = 0d;

            if ( itemsDTO.getTanggungan().equals(1)  ){
                total_tanggungan = tanggungan *= 1;
            }else if (itemsDTO.getTanggungan().equals(2)){
                total_tanggungan = tanggungan *= 2;
            }else if (itemsDTO.getTanggungan().equals(3)){
                total_tanggungan = tanggungan *= 3;
            }


            Double potongJabatan =  (itemsDTO.getBruto() * 5) / 100;
            nett = itemsDTO.getBruto() - potongJabatan;

            PTKP = PTKP + total_tanggungan;

            Double PKP = (nett * 12) - PTKP;

            Double jumlahPPhPertahun = 0d;
            Double jumlahPPhperbulan = 0d;
            if ( PKP < 60000000d){
                jumlahPPhPertahun = (PKP * 5) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 60000000d && PKP < 250000000d ){
                jumlahPPhPertahun = (PKP * 15) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 250000000d && PKP < 500000000d){
                jumlahPPhPertahun = (PKP * 25) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 500000000d && PKP < 5000000000d){
                jumlahPPhPertahun = (PKP * 30) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP > 5000000000d){
                jumlahPPhPertahun = (PKP * 35) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            }


            if (PKP < 0){
                PKP = 0d;
                jumlahPPhperbulan = 0d;
                jumlahPPhPertahun = 0d;
                PTKP = 0d;
            }

            itemUpdate.setName(itemsDTO.getName());
            itemUpdate.setJenisKelamin(itemsDTO.getJenisKelamin());
            itemUpdate.setStatusMenikah(itemsDTO.getStatusMenikah());
            itemUpdate.setPasangan(itemsDTO.getPasangan());
            itemUpdate.setTanggungan(itemsDTO.getTanggungan());
            itemUpdate.setBruto(itemsDTO.getBruto());
            itemUpdate.setNett(nett);
            itemUpdate.setPtkp(PTKP);
            itemUpdate.setPkp(PKP);
            itemUpdate.setJumlahPphPerbalun(jumlahPPhperbulan);
            itemUpdate.setJumlahPphPertahun(jumlahPPhPertahun);

            repository.save(itemUpdate);

        }

        if ( itemsDTO.getJenisKelamin().equals("pria") && itemsDTO.getStatusMenikah().equals(true) &&
                (itemsDTO.getPasangan().equals("iya") || itemsDTO.getPasangan().equals("tidak")) ){
            log.info("Dua");
            Double total_tanggungan = 0d;

            if ( itemsDTO.getTanggungan().equals(1)  ){
                total_tanggungan = tanggungan *= 1;
            }else if (itemsDTO.getTanggungan().equals(2)){
                total_tanggungan = tanggungan *= 2;
            }else if (itemsDTO.getTanggungan().equals(3)) {
                total_tanggungan = tanggungan *= 3;

            }
            Double potongJabatan =  (itemsDTO.getBruto() * 5) / 100;
            nett = itemsDTO.getBruto() - potongJabatan;

            PTKP = PTKP + kawin + total_tanggungan;

            Double PKP = (nett * 12) - PTKP;

            Double jumlahPPhPertahun = 0d;
            Double jumlahPPhperbulan = 0d;
            if ( PKP < 60000000d){
                jumlahPPhPertahun = (PKP * 5) / 100;

            } else if (PKP >= 60000000d && PKP < 250000000d ){
                jumlahPPhPertahun = (PKP * 15) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 250000000d && PKP < 500000000d){
                jumlahPPhPertahun = (PKP * 25) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 500000000d && PKP < 5000000000d){
                jumlahPPhPertahun = (PKP * 30) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP > 5000000000d){
                jumlahPPhPertahun = (PKP * 35) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            }

            if (PKP < 0){
                PKP = 0d;
                jumlahPPhperbulan = 0d;
                jumlahPPhPertahun = 0d;
                PTKP = 0d;
            }

            itemUpdate.setName(itemsDTO.getName());
            itemUpdate.setJenisKelamin(itemsDTO.getJenisKelamin());
            itemUpdate.setStatusMenikah(itemsDTO.getStatusMenikah());
            itemUpdate.setPasangan(itemsDTO.getPasangan());
            itemUpdate.setTanggungan(itemsDTO.getTanggungan());
            itemUpdate.setBruto(itemsDTO.getBruto());
            itemUpdate.setPtkp(PTKP);
            itemUpdate.setPkp(PKP);
            itemUpdate.setJumlahPphPerbalun(jumlahPPhperbulan);
            itemUpdate.setNett(nett);
            itemUpdate.setJumlahPphPertahun(jumlahPPhPertahun);

            repository.save(itemUpdate);
        }

        if ( itemsDTO.getJenisKelamin().equals("wanita") && itemsDTO.getStatusMenikah().equals(true) && itemsDTO.getPasangan().equals("iya")) {
            log.info("TIga");
            Double total_tanggungan = 0d;

            if ( itemsDTO.getTanggungan().equals(1)  ){
                total_tanggungan = tanggungan *= 1;
            }else if (itemsDTO.getTanggungan().equals(2)){
                total_tanggungan = tanggungan *= 2;
            }else if (itemsDTO.getTanggungan().equals(3)){
                total_tanggungan = tanggungan *= 3;
            }


            Double potongJabatan =  (itemsDTO.getBruto() * 5) / 100;
            nett = itemsDTO.getBruto() - potongJabatan;

            PTKP = PTKP + total_tanggungan;

            Double PKP = (nett * 12) - PTKP;

            Double jumlahPPhPertahun = 0d;
            Double  jumlahPPhperbulan = 0d;
            if ( PKP < 60000000d){
                jumlahPPhPertahun = (PKP * 5) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 60000000d && PKP < 250000000d ){
                jumlahPPhPertahun = (PKP * 15) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 250000000d && PKP < 500000000d){
                jumlahPPhPertahun = (PKP * 25) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 500000000d && PKP < 5000000000d){
                jumlahPPhPertahun = (PKP * 30) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP > 5000000000d){
                jumlahPPhPertahun = (PKP * 35) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            }

            if (PKP < 0){
                PKP = 0d;
                jumlahPPhperbulan = 0d;
                jumlahPPhPertahun = 0d;
                PTKP = 0d;
            }


            itemUpdate.setName(itemsDTO.getName());
            itemUpdate.setJenisKelamin(itemsDTO.getJenisKelamin());

            itemUpdate.setStatusMenikah(itemsDTO.getStatusMenikah());

            itemUpdate.setPasangan(itemsDTO.getPasangan());

            itemUpdate.setTanggungan(itemsDTO.getTanggungan());

            itemUpdate.setBruto(itemsDTO.getBruto());

            itemUpdate.setNett(nett);

            itemUpdate.setPtkp(PTKP);

            itemUpdate.setPkp(PKP);

            itemUpdate.setJumlahPphPerbalun(jumlahPPhperbulan);

            itemUpdate.setJumlahPphPertahun(jumlahPPhPertahun);

            repository.save(
                    itemUpdate);

        }

        if ( itemsDTO.getJenisKelamin().equals("wanita") && itemsDTO.getStatusMenikah().equals(true) &&
                itemsDTO.getPasangan().equals("tidak") ){
            log.info("Empat");
            Double total_tanggungan = 0d;

            if ( itemsDTO.getTanggungan().equals(1)  ){
                total_tanggungan = tanggungan *= 1;
            }else if (itemsDTO.getTanggungan().equals(2)){
                total_tanggungan = tanggungan *= 2;
            }else if (itemsDTO.getTanggungan().equals(3)){
                total_tanggungan = tanggungan *= 3;
            }

            Double potongJabatan =  (itemsDTO.getBruto() * 5) / 100;
            nett = itemsDTO.getBruto() - potongJabatan;

            PTKP = PTKP + kawin + total_tanggungan;
            Double PKP = (nett * 12) - PTKP;

            Double jumlahPPhPertahun = 0d;
            Double jumlahPPhperbulan = 0d;
            if ( PKP < 60000000d){
                jumlahPPhPertahun = (PKP * 5) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 60000000d && PKP < 250000000d ){
                jumlahPPhPertahun = (PKP * 15) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 250000000d && PKP < 500000000d){
                jumlahPPhPertahun = (PKP * 25) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP >= 500000000d && PKP < 5000000000d){
                jumlahPPhPertahun = (PKP * 30) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            } else if (PKP > 5000000000d){
                jumlahPPhPertahun = (PKP * 35) / 100;
                jumlahPPhperbulan = jumlahPPhPertahun / 12;
            }

            if (PKP < 0){
                PKP = 0d;
                jumlahPPhperbulan = 0d;
                jumlahPPhPertahun = 0d;
                PTKP = 0d;
            }

            itemUpdate.setName(itemsDTO.getName());

            itemUpdate.setJenisKelamin(itemsDTO.getJenisKelamin());

            itemUpdate.setStatusMenikah(itemsDTO.getStatusMenikah());

            itemUpdate.setPasangan(itemsDTO.getPasangan());

            itemUpdate.setTanggungan(itemsDTO.getTanggungan());

            itemUpdate.setBruto(itemsDTO.getBruto());

            itemUpdate.setPtkp(PTKP);

            itemUpdate.setPkp(PKP);

            itemUpdate.setJumlahPphPerbalun(jumlahPPhperbulan);

            itemUpdate.setNett(nett);

            itemUpdate.setJumlahPphPertahun(jumlahPPhPertahun);

            repository.save(
                    itemUpdate);
        }


    }

    public void delete(Long id){

        repository.deleteById(id);
    }




}
