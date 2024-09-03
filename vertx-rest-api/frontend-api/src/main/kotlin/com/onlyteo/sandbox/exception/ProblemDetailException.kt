package com.onlyteo.sandbox.exception

import com.onlyteo.sandbox.model.ProblemDetails

class ProblemDetailException(problemDetails: ProblemDetails) : RuntimeException(problemDetails.detail)