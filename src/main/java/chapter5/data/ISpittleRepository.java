package chapter5.data;

import chapter5.base.Spittle;

import java.util.List;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/11/24.
 */
public interface ISpittleRepository {
    List<Spittle> findRecentSpittles();
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long id);
    void save(Spittle spittle);
}
