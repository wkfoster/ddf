/**
 * Copyright (c) Codice Foundation
 *
 * This is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or any later version. 
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details. A copy of the GNU Lesser General Public License is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 *
 **/
package ddf.content.storage;

import ddf.content.operation.CreateRequest;
import ddf.content.operation.CreateResponse;
import ddf.content.operation.DeleteRequest;
import ddf.content.operation.DeleteResponse;
import ddf.content.operation.ReadRequest;
import ddf.content.operation.ReadResponse;
import ddf.content.operation.UpdateRequest;
import ddf.content.operation.UpdateResponse;

/**
 * External facing (outside of {@link ContentFramework}) API used to interact
 * with providers of data such as a file system or database. The basic premise
 * of a StorageProvider is to allow read, create, update, and delete
 * operations on actual content (vs. metadata about content).
 * 
 * @author Hugh Rodgers, Lockheed Martin
 * @author ddf.isgs@lmco.com
 *
 */
public interface StorageProvider
{

    /**
     * Creates a {@link ContentItem} in the content repository.
     * 
     * @param createRequest
     *     the {@link CreateRequest} that contains the {@link ContentItem} to be
     *     stored/created in the content repository. The ID of the {@link ContentItem}
     *     will be auto-generated by the StorageProvider.
     * @return
     *     the {@link CreateResponse} that contains the {@link ContentItem} created
     *     by the StorageProvider in the content repository. This {@link ContentItem}
     *     will contain the GUID assigned by the StorageProvider. This GUID will be used
     *     in subsequent {@link UpdateRequest}, {@link ReadRequest}, and {@link DeleteRequest}
     *     to access the stored {@link ContentItem}.
     * @throws StorageException
     *     if any problems encountered while creating/storing the {@link ContentItem}
     */
    public CreateResponse create( CreateRequest createRequest ) throws StorageException;
    

    /**
     * Retrieves a {@link ContentItem} from the content repository.
     * 
     * @param readRequest 
     *     the {@link ReadRequest} that contains the GUID of the {@link ContentItem} to be retrieved
     * @return
     *     the {@link ReadResponse} that contains the {@link ContentItem} retrieved by
     *     the StorageProvider from the content repository.
     * @throws StorageException
     *     if any problems encountered while retrieving the {@link ContentItem}
     */
    public ReadResponse read( ReadRequest readRequest ) throws StorageException;
    

    /**
     * Updates a {@link ContentItem} in the content repository. The {@link ContentItem}
     * must already exist in the content repository in order to be updated. The StorageProvider
     * will not automatically create the {@link ContentItem} if it does not exist.
     * 
     * @param updateRequest
     *     the {@link UpdateRequest} that contains the GUID of the {@link ContentItem} to
     *     be updated and the {@link InputStream} with the new data to overwrite the existing
     *     {@link ContentItem} in the content repository.
     * @return
     *     the {@link UpdateResponse} that contains the {@link ContentItem} updated
     *     by the StorageProvider in the content repository.
     * @throws StorageException
     *     if any problems encountered while updating the {@link ContentItem}
     */
    public UpdateResponse update( UpdateRequest updateRequest ) throws StorageException;
    
   
    /**
     * Deletes a {@link ContentItem} from the content repository.
     * 
     * @param deleteRequest
     *     the {@link DeleteRequest} that contains the GUID of the {@link ContentItem} to
     *     be deleted.
     * @return
     *     the {@link DeleteResponse} that contains the status of the deletion of the
     *     {@link ContentItem} from the content repository.
     * @throws StorageException
     *     if any problems encountered while deleting the {@link ContentItem}
     */
    public DeleteResponse delete( DeleteRequest deleteRequest ) throws StorageException;
    
    
    // TODO: transaction support
//    public boolean commit( CreateResponse input );
//    public boolean rollback( CreateResponse input );
//    public boolean commit( UpdateResponse input );
//    public boolean rollback( UpdateResponse input );
//    public boolean commit( DeleteResponse input );
//    public boolean rollback( DeleteResponse input );
}
