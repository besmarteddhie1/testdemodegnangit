package com.ahm.jx.arch.dao;

import com.ahm.jx.arch.model.AhmsdttmMstclusterArch;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by eddhie on 26/09/16.
 */
public class temp implements AhmsdttmMstclusterDao{

    @Override
    public <S extends T> S save(S s) {
        return null;
    }

    @Override
    public AhmsdttmMstclusterArch findOne(Integer integer) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public List<AhmsdttmMstclusterArch> findAll() {`
        return null;
    }

    @Override
    public List<AhmsdttmMstclusterArch> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AhmsdttmMstclusterArch> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<AhmsdttmMstclusterArch> findAll(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void delete(AhmsdttmMstclusterArch ahmsdttmMstclusterArch) {

    }

    @Override
    public void delete(Iterable<? extends AhmsdttmMstclusterArch> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable<AhmsdttmMstclusterArch> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AhmsdttmMstclusterArch getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends T> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends T> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return false;
    }
}
