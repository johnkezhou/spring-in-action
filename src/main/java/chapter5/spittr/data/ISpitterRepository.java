package chapter5.spittr.data;

import chapter5.spittr.base.Spitter;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/11/24.
 */
public interface ISpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}
