package com.boot.service

import com.boot.model.BaseModel
import com.boot.model.BaseResponseModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.EntityNotFoundException
import javax.persistence.PersistenceContext

@Service
abstract class BaseService<
//    PostRequestModel,
//    PutRequestModel,
    ResponseModel : BaseResponseModel,
    E : BaseModel,
    R : BaseRepository<E>
    >() : BaseContext<R>() {



//    // To pad new customized details for record
//    // e.g. for eventEntity or newsEntity in banner
//    open fun getRecordDetails(recordEntity: E): E {
//        return recordEntity
//    }
//
    open fun getAllRecords(): List<ResponseModel> {
        return repo.findAll().mapNotNull {it as ResponseModel}
    }
//
//    open fun getAllRecords(searchCriteria: List<SearchCriteria>?, pageParam: PageParamModel): PageModel<ResponseModel> {
//        val pageRequest =
//            PageRequest.of(pageParam.pageIndex - 1, pageParam.pageSize, Sort(Sort.Direction.DESC, "createdAt"))
//
//        val pageLead = repo.findAll(pageRequest)
//        return PageModel(
//            currentPageIndex = pageParam.pageIndex,
//            pageSize = pageParam.pageSize,
//            pageCount = pageLead.totalPages,
//            items = pageLead.content.map { (getRecordDetails(it) modelOf requestLocale) as ResponseModel }
//        )
//    }

    open fun getRecord(recordId: Long): Any {
        val record = repo.findById(recordId)
        if (record.isPresent) {
            return record.get()
        }

        throw EntityNotFoundException("There is no entity exists with id $recordId !")
    }

//    // This function could be overwritten in the child classes
//    open fun getCreateRecordEntity(recordRequest: PostRequestModel): BaseEntity {
//        return BaseEntity() setCreator currentUser
//    }
//
//    @Transactional(readOnly = false)
//    open fun createRecord(recordRequest: PostRequestModel): ResponseModel {
//        val recordEntity = getCreateRecordEntity(recordRequest)
//        em saveAndFlush recordEntity
//        return (recordEntity modelOf requestLocale) as ResponseModel
//    }
//
//    // This function could be overwritten in the child classes
//    open fun updateRecordEntity(recordId: Long, recordRequest: PutRequestModel): BaseEntity {
//        return getEntity<E>(recordId)
//    }
//
//    @Transactional(readOnly = false)
//    open fun updateRecord(recordId: Long, recordRequest: PutRequestModel): BaseDataResponseModel {
//        val recordEntity = updateRecordEntity(recordId, recordRequest)
//        recordEntity setUpdator currentUser
//        em saveAndFlush recordEntity
//        return (recordEntity modelOf requestLocale) as BaseDataResponseModel
//    }
//
//    @Transactional(readOnly = false)
//    open fun deleteRecord(recordId: Long): BaseDeletedDataResponseModel {
//        val recordEntity = getEntityOrNull<E>(recordId)
//        recordEntity?.let { em delAndFlush it }
//        return BaseDeletedDataResponseModel(recordId)
//    }
}
