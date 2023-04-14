package org.j2os.project.api;

import org.j2os.project.common.exception.ValidationException;
import org.j2os.project.common.json.JSON;
import org.j2os.project.common.wrapper.ErrorHandler;
import org.j2os.project.entity.Person;
import org.j2os.project.service.PersonService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Path("/person")
public class PersonController {
    @Produces("application/json")
    @GET
    @Path("/save")
    public String save(@QueryParam("name") String name, @QueryParam("family") String family, @QueryParam("salary") String salary) throws Exception {
        try {
            if (name == null || family == null || name.isEmpty() || family.isEmpty())
                throw new ValidationException();
            return JSON.get(PersonService
                    .getInstance()
                    .save(new Person().setName(name).setFamily(family).setSalary(Long.parseLong(salary)))
                    .findAll());
        } catch (Exception e) {
            return JSON.get(ErrorHandler.getError(e));
        }
    }

    @Produces("application/json")
    @GET
    @Path("/asyncSave")
    public String asyncSave(@QueryParam("name") String name, @QueryParam("family") String family, @QueryParam("salary") String salary) throws Exception {
        try {
            return JSON.get(PersonService
                    .getInstance()
                    .asyncSave(new Person().setName(name).setFamily(family).setSalary(Long.parseLong(salary)))
                    .findAll());
        } catch (Exception e) {
            return JSON.get(ErrorHandler.getError(e));
        }
    }

    @Produces("application/json")
    @GET
    @Path("/update")
    public String update(@QueryParam("id") String id, @QueryParam("name") String name, @QueryParam("family") String family, @QueryParam("salary") String salary) throws Exception {
        try {
            return JSON.get(PersonService
                    .getInstance()
                    .update(new Person().setId(Long.parseLong(id)).setName(name).setFamily(family).setSalary(Long.parseLong(salary)))
                    .findAll());
        } catch (Exception e) {
            return JSON.get(ErrorHandler.getError(e));
        }
    }

    @Produces("application/json")
    @GET
    @Path("/remove")
    public String remove(@QueryParam("id") String id) throws Exception {
        try {
            return JSON.get(PersonService
                    .getInstance()
                    .remove(new Person().setId(Long.parseLong(id)))
                    .findAll());
        } catch (Exception e) {
            return JSON.get(ErrorHandler.getError(e));
        }
    }

    @Produces("application/json")
    @GET
    @Path("/findAll")
    public String findAll() throws Exception {
        try {
            return JSON.get(PersonService
                    .getInstance()
                    .findAll());
        } catch (Exception e) {
            return JSON.get(ErrorHandler.getError(e));
        }
    }

    @Produces("application/json")
    @GET
    @Path("/findOne")
    public String findOne(@QueryParam("id") String id) throws Exception {
        try {
            return JSON.get(PersonService
                    .getInstance()
                    .findOne(new Person().setId(Long.parseLong(id))));
        } catch (Exception e) {
            return JSON.get(ErrorHandler.getError(e));
        }
    }
}
