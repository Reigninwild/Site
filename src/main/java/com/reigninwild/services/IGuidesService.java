package com.reigninwild.services;

import java.util.List;

import com.reigninwild.orm.Guides;

public interface IGuidesService {

    public void saveGuides(Guides guide);

    public void deleteGuides(Guides guide);

    public void updateGuides(Guides guide);

    public List<Guides> getAllGuides();
}
