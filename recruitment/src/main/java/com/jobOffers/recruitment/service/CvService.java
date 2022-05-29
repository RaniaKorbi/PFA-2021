package com.jobOffers.recruitment.service;

import com.jobOffers.recruitment.dao.CvDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.jobOffers.recruitment.model.Cv;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.List;
@Service
public class CvService {
    private final CvDao cvDao;
    @Autowired
    public CvService(CvDao cvDao) {
        this.cvDao = cvDao;
    }
    public Cv store(MultipartFile file,String email) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        Cv FileDB = new Cv(fileName, file.getContentType(), file.getBytes(),email);

        return cvDao.save(FileDB);
    }

    public Cv getFile(String idCv) {
        return cvDao.findById(idCv).get();
    }

    public Stream<Cv> getAllFiles() {
        return cvDao.findAll().stream();
    }}

