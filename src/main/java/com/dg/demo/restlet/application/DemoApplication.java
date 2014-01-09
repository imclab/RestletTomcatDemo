package com.dg.demo.restlet.application;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.Router;

import com.dg.demo.restlet.resource.CityXMLResource;
import com.dg.demo.restlet.resource.MapResource;
import com.dg.demo.restlet.resource.SystemResource;

/**
 * The Application Root Class.  Maps all of the resources.
 */
public class DemoApplication extends Application {

    /**
     * Creates a new DemoApplication object.
     */
    public DemoApplication() {
        //empty
    }

    /**
     * Public Constructor to create an instance of DemoApplication.
     *
     * @param parentContext - the org.restlet.Context instance
     */
    public DemoApplication(Context parentContext) {
        super(parentContext);
    }

    /**
     * The Restlet instance that will call the correct resource
     * depending on URL mapped to it.
     *
     * @return -- The resource Restlet mapped to the URL.
     */
    @Override
    public Restlet createRoot() {
        Router router = new Router(getContext());

        router.attach("/sys", SystemResource.class);
        router.attach("/{key}/maps", MapResource.class);
        router.attach("/xml", CityXMLResource.class);
        return router;
    }
}